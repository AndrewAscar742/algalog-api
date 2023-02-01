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
public class ReturnClienteDto{
	private Long id; 
	private String nome; 
	private String email; 
	private String telefone; 
	private OffsetDateTime data_requisicao = OffsetDateTime.now();
}
