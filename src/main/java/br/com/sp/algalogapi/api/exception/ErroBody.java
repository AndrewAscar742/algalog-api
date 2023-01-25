package br.com.sp.algalogapi.api.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.sp.algalogapi.domain.exception.NegocioException;
import lombok.Getter;
import lombok.Setter;
@JsonInclude(value = Include.NON_NULL)
@Getter
@Setter
public class ErroBody {
	private Integer status;
	private LocalDateTime data_horario;
	private String titulo;
	private List<Campo> campos;
	
	
	public void prepararResposta(HttpStatus status, List<Campo> campos) {
		this.status = status.value();
		this.data_horario = LocalDateTime.now();
		this.titulo = "Um ou mais campos estão inválidos, preencha novamente";
		this.campos = campos;
		
	}


	public void prepararResposta(HttpStatus status, NegocioException ex) {
		this.status = status.value();
		this.data_horario = LocalDateTime.now();
		this.titulo = ex.getMessage();
		
	}
}
