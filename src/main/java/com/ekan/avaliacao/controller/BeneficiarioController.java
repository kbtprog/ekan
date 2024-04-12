package com.ekan.avaliacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ekan.avaliacao.exception.InternalServerErrorException;
import com.ekan.avaliacao.exception.ResourceNotFoundException;
import com.ekan.avaliacao.model.dto.BeneficiarioDTO;
import com.ekan.avaliacao.model.dto.BeneficiarioInputDTO;
import com.ekan.avaliacao.model.dto.BeneficiarioUpdateDTO;
import com.ekan.avaliacao.service.BeneficiarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/beneficiario")
public class BeneficiarioController {

	@Autowired
	private BeneficiarioService service;

	@GetMapping
	public ResponseEntity<List<BeneficiarioDTO>> getAllBeneficiarios(){
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllBeneficiarios());		
	}

	@PutMapping
	public ResponseEntity<?> insertBeneficiario(@Valid @RequestBody BeneficiarioInputDTO beneficiarioInputDTO) throws InternalServerErrorException {
		
		BeneficiarioDTO insertBeneficiario = service.insertBeneficiario(beneficiarioInputDTO);
		
		if (insertBeneficiario != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(insertBeneficiario);
		} else {
			throw new InternalServerErrorException("Erro na inserção de Beneficiario");
		}
	}

	@PostMapping
	public ResponseEntity<?> updateBeneficiario(
			@RequestParam("id") Long id, 
			@RequestBody BeneficiarioUpdateDTO beneficiarioUpdateDTO) throws Exception {
		
		service.updateBeneficiario(id, 
				new BeneficiarioInputDTO(
						beneficiarioUpdateDTO.getNome(), 
						beneficiarioUpdateDTO.getTelefone(), 
						null, 
						beneficiarioUpdateDTO.getDataNascimento()));
		
		
		return ResponseEntity.status(HttpStatus.OK).body("Beneficiario atualizado com sucesso");
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteBeneficiario(@RequestParam("id") Long id) throws ResourceNotFoundException {		
		service.deleteBeneficiario(id);
		return ResponseEntity.status(HttpStatus.OK).body("Beneficiario e seus respectivos documentos excluidos com sucesso");
	}
}