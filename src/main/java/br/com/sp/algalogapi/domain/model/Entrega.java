package br.com.sp.algalogapi.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.sp.algalogapi.api.dto.EntregaDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(value = Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "entregas")

public class Entrega {
	@EqualsAndHashCode.Include
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Cliente cliente;
	
	@Embedded
	private Destinatario destinatario;
	
	private BigDecimal taxa;
	
	@Enumerated(EnumType.STRING)
	private StatusEntrega status;
	
	private OffsetDateTime data_pedido;
	private OffsetDateTime data_finalizacao;
	
	public Entrega(EntregaDto entregaDto, Cliente cliente) {
		this.cliente = cliente;
		this.destinatario = entregaDto.destinatario();
		this.taxa = entregaDto.taxa();
		this.status = StatusEntrega.PENDENTE;
		this.data_pedido = OffsetDateTime.now();
	}
}
