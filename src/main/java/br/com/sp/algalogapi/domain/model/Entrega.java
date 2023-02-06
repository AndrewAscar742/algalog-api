package br.com.sp.algalogapi.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.sp.algalogapi.domain.exception.NegocioException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(value = Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "Entrega")
@Table(name = "entregas")

public class Entrega {
	@EqualsAndHashCode.Include
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Cliente cliente;
	
	@Embedded
	private Destinatario destinatario;
	
	@OneToMany(mappedBy = "entrega", cascade = CascadeType.MERGE , fetch = FetchType.LAZY)
	private List<Ocorrencia> ocorrencias = new ArrayList<>();
	
	private BigDecimal taxa;
	
	@Enumerated(EnumType.STRING)
	private StatusEntrega status = StatusEntrega.PENDENTE;
	
	private OffsetDateTime data_pedido = OffsetDateTime.now();
	private OffsetDateTime data_finalizacao;
	
	public Ocorrencia adicionarOcorrencia(String descricao) {
		Ocorrencia ocorrencia = new Ocorrencia(id, this, descricao, OffsetDateTime.now());
		ocorrencias.add(ocorrencia);
		
		return ocorrencia;
		
	}
	
	public void finalizar() {
		if (naoPodeSerFinalizado())
			throw new NegocioException("A entrega não pode ser finalizada!");
		
		setStatus(StatusEntrega.FINALIZADO);
		setData_finalizacao(OffsetDateTime.now());
	}
	
	public boolean podeSerFinalizado() {
		return StatusEntrega.PENDENTE.equals(getStatus());
	}
	
	public boolean naoPodeSerFinalizado() {
		return !podeSerFinalizado();
	}
	
}
