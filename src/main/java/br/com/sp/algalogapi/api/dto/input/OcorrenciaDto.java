package br.com.sp.algalogapi.api.dto.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaDto {
	
	@NotBlank
	private String descricao;
}
