package br.com.sp.algalogapi.api.dto.output;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostOcorrenciaDto {
	private Long id;
	private String descricao;
	private OffsetDateTime dataRegistro;
}
