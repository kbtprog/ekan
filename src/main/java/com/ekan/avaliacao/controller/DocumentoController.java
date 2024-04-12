package com.ekan.avaliacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ekan.avaliacao.exception.ResourceNotFoundException;
import com.ekan.avaliacao.model.dto.DocumentoDTO;
import com.ekan.avaliacao.service.DocumentoService;

@RestController
@RequestMapping(value = "/documento")
public class DocumentoController {

	@Autowired
	private DocumentoService service;
	
	@GetMapping
	public ResponseEntity<List<DocumentoDTO>> getAllDocumentsByBeneficiarioId(@RequestParam("id") Long id) throws ResourceNotFoundException {
		List<DocumentoDTO> result = service.getAllByBeneficiarioId(id);
		
		if (result.isEmpty()) {
			throw new ResourceNotFoundException("Documentos não encontrado para este Beneficiario");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(result);
		}
	}
}