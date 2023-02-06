package br.com.sp.algalogapi.api.dto.output;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReturnOcorrenciaDto {
	
	private Long id;
	
	private ReturnEntregaDto entrega;
	private String descricao;
	private OffsetDateTime dataRegistro;
}
