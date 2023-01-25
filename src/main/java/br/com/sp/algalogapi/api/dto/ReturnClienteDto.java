package br.com.sp.algalogapi.api.dto;

import br.com.sp.algalogapi.domain.model.Cliente;

public record ReturnClienteDto(Long id, String nome, String email, String telefone) {
	
	public ReturnClienteDto(Cliente cliente) {
		this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone());
	}
}
