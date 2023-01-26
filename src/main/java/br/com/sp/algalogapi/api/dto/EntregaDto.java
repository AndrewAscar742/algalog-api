package br.com.sp.algalogapi.api.dto;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import br.com.sp.algalogapi.domain.ValidationGroup;
import br.com.sp.algalogapi.domain.model.Cliente;
import br.com.sp.algalogapi.domain.model.Destinatario;
import br.com.sp.algalogapi.domain.model.Entrega;

public record EntregaDto(
		@ConvertGroup(from = Default.class, to = ValidationGroup.class)
		@Valid
		@NotNull
		Cliente cliente,
		@Valid
		@NotNull
		Destinatario destinatario,
		@NotNull
		BigDecimal taxa) {
	
}
