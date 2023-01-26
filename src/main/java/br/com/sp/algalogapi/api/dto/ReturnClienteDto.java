package br.com.sp.algalogapi.api.dto;

import java.time.OffsetDateTime;

import br.com.sp.algalogapi.domain.model.Cliente;

public record ReturnClienteDto(Long id, String nome, String email, String telefone, OffsetDateTime data_requisicao) {
	
	public ReturnClienteDto(Cliente cliente) {
		this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), OffsetDateTime.now());
	}
}
