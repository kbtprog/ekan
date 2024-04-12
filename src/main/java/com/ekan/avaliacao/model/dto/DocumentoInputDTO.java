package com.ekan.avaliacao.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Valid
@Getter
@Setter
@AllArgsConstructor
public class DocumentoInputDTO {

	@NotNull(message = "tipo documento é obrigatório")
	private String tipoDocumento;
	
	@NotNull(message = "descricao é obrigatório")
	private String descricao;
}