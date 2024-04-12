package com.ekan.avaliacao.model.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiarioInputDTO {
	
	@NotNull(message = "nome é obrigatorio")
	private String nome;
	
	@NotNull(message = "telefone é obrigatorio")
	private String telefone;
	
	@Valid
	@NotNull(message = "documentos é obrigatorio")
	private List<DocumentoInputDTO> documentos;

	@NotNull(message = "data de nascimento é obrigatorio")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dataNascimento;
}