package br.com.sp.algalogapi.api.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import br.com.sp.algalogapi.domain.model.Cliente;
import br.com.sp.algalogapi.domain.model.Destinatario;
import br.com.sp.algalogapi.domain.model.Entrega;
import br.com.sp.algalogapi.domain.model.StatusEntrega;

public record ReturnEntregaDto(
		Long id, 
		Cliente cliente, 
		Destinatario destinatario, 
		BigDecimal taxa, 
		StatusEntrega status,
		OffsetDateTime data_pedido) {
	
	public ReturnEntregaDto(Entrega entrega) {
		this(entrega.getId(), entrega.getCliente(), entrega.getDestinatario(), entrega.getTaxa(), entrega.getStatus(), entrega.getData_pedido());
	}
}
