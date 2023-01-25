package br.com.sp.algalogapi.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.sp.algalogapi.domain.model.Cliente;

public record ClienteDto(
		@NotBlank
		@Size(min = 3 ,max = 60)
		String nome, 
		@NotBlank
		@Email
		@Size(min = 3 ,max = 255)
		String email, 
		@NotBlank
		String telefone) {
	
	public ClienteDto(Cliente cliente) {
		this(cliente.getNome(), cliente.getEmail(), cliente.getTelefone());
	}

}
