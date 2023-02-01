package br.com.sp.algalogapi.api.dto.output;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import br.com.sp.algalogapi.api.dto.input.DestinatarioModel;
import br.com.sp.algalogapi.domain.model.Cliente;
import br.com.sp.algalogapi.domain.model.StatusEntrega;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReturnEntregaDto{
	
	private Long id;
	private Cliente cliente; 
	private DestinatarioModel destinatario; 
	private BigDecimal taxa; 
	private StatusEntrega status;
	private OffsetDateTime data_pedido;
	
}
		
