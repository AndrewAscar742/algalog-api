package br.com.sp.algalogapi.api.dto.input;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import br.com.sp.algalogapi.domain.ValidationGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntregaDto{
	
	@ConvertGroup(from = Default.class, to = ValidationGroup.class)
	@Valid
	@NotNull
	private ClienteDto cliente;
	@Valid
	@NotNull
	private DestinatarioModel destinatario;
	@NotNull
	private BigDecimal taxa;
}
		
	

