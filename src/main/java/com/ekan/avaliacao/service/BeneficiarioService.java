package com.ekan.avaliacao.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekan.avaliacao.exception.InternalServerErrorException;
import com.ekan.avaliacao.exception.ResourceNotFoundException;
import com.ekan.avaliacao.model.dto.BeneficiarioDTO;
import com.ekan.avaliacao.model.dto.BeneficiarioInputDTO;
import com.ekan.avaliacao.model.dto.DocumentoDTO;
import com.ekan.avaliacao.model.dto.DocumentoInputDTO;
import com.ekan.avaliacao.model.entity.Beneficiario;
import com.ekan.avaliacao.repository.BeneficiarioRepository;

@Service
public class BeneficiarioService {
	
	@Autowired
	private BeneficiarioRepository repository;
	
	@Autowired
	private DocumentoService documentoService;
	
	public List<BeneficiarioDTO> getAllBeneficiarios() {
		
		return repository.findAll()
				.stream()
				.map(beneficiario -> new BeneficiarioDTO(
								beneficiario.getId(), 
								beneficiario.getNome(), 
								beneficiario.getTelefone(), 
								beneficiario.getDataNascimento(), 
								beneficiario.getDataInclusao(), 
								beneficiario.getDataAtualizacao(), 
								documentoService.getAllByBeneficiarioId(beneficiario.getId())))
				.collect(Collectors.toList());
	}
	
	public BeneficiarioDTO insertBeneficiario(BeneficiarioInputDTO dto) throws InternalServerErrorException {
		
		Beneficiario newBeneficiario = new Beneficiario(null, dto.getNome(), dto.getTelefone(), dto.getDataNascimento(), null, null);
		newBeneficiario.setDataInclusao(LocalDateTime.now());
		
		try {
			Beneficiario result = repository.save(newBeneficiario);
			List<DocumentoDTO> newDocumentosDTO = new ArrayList<DocumentoDTO>();
			
		
			for (DocumentoInputDTO documentoInput : dto.getDocumentos()) {
				DocumentoDTO documento = new DocumentoDTO(
						null, 
						documentoInput.getTipoDocumento(), 
						documentoInput.getDescricao(), 
						LocalDateTime.now(), 
						null, 
						result.getId());
				
				newDocumentosDTO.add(documentoService.saveDocumento(documento));
				
				return new BeneficiarioDTO(
						result.getId(), 
						result.getNome(), 
						result.getTelefone(), 
						result.getDataNascimento(), 
						LocalDateTime.now(), 
						null, 
						newDocumentosDTO);
			} 
		} catch (Exception e) {
			throw new InternalServerErrorException("Erro ao inserir beneficiario");
		}
		return null;
	}
	
	public void updateBeneficiario(Long id, BeneficiarioInputDTO dto) throws Exception {
		
		Optional<Beneficiario> checkBeneficiario = repository.findById(id);
		
		if (checkBeneficiario.isEmpty()) {
			throw new ResourceNotFoundException("Beneficiario não localizado para alteração");
		} else {			
			repository.save(processBeneficiarioUpdate(checkBeneficiario.get(), dto));
		}
	}
	
	private Beneficiario processBeneficiarioUpdate(Beneficiario beneficiario, BeneficiarioInputDTO dto) {
		beneficiario.setNome(dto.getNome() != null ? dto.getNome() : beneficiario.getNome());
		
		beneficiario.setTelefone(dto.getTelefone() != null ? dto.getTelefone() : beneficiario.getTelefone());
		
		beneficiario.setDataNascimento(dto.getDataNascimento() != null ? dto.getDataNascimento() : beneficiario.getDataNascimento());
		
		beneficiario.setDataAtualizacao(LocalDateTime.now());
		
		return beneficiario;
	}
	
	public Boolean deleteBeneficiario(Long id) throws ResourceNotFoundException {

		Optional<Beneficiario> checkBeneficiario = repository.findById(id);

		if (checkBeneficiario.isEmpty()) {
			throw new ResourceNotFoundException("Beneficiario não encontrado");
		}

		documentoService.deleteAllDocumentsByBeneficiarioId(id);
		repository.deleteById(id);
		
		return true;
	}
}