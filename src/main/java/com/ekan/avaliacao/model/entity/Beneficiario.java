package com.ekan.avaliacao.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Beneficiario {

	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "dataNascimento")
	private LocalDate dataNascimento;
	
	@Column(name = "dataInclusao")
	private LocalDateTime dataInclusao;

	@Column(name = "dataAtualizacao")	
	private LocalDateTime dataAtualizacao;
	
	@Override
	public String toString() {
		return "Beneficiario{ "
				+ "Id: " + id + '\'' + ","  
				+ "Nome: " + nome + '\'' + ","
				+ "Telefone: " + telefone + '\'' + ","
				+ "Data Nascimento: " + dataNascimento + '\'' + ","
				+ "Data Inclusao: " + dataInclusao + '\'' + ","
				+ "Data Atualizacao: " + dataAtualizacao + '\'' + "}";
	}
}