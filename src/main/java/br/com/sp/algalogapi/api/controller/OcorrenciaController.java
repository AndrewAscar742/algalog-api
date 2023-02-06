package br.com.sp.algalogapi.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sp.algalogapi.api.dto.input.OcorrenciaDto;
import br.com.sp.algalogapi.api.dto.output.PostOcorrenciaDto;
import br.com.sp.algalogapi.api.dto.output.ReturnOcorrenciaDto;
import br.com.sp.algalogapi.domain.service.OcorrenciaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{id}/ocorrencias")
public class OcorrenciaController {
	
	private OcorrenciaService ocorrenciaService;
	
	@GetMapping
	public List<ReturnOcorrenciaDto> listarOcorrencias(@PathVariable Long id){
		return ocorrenciaService.listarOcorrencias(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PostOcorrenciaDto registrarOcorrencia(@PathVariable Long id, 
			@RequestBody @Valid OcorrenciaDto ocorrenciaDto) {
		
		return ocorrenciaService.registrarOcorrencia(id, ocorrenciaDto.getDescricao());
		
	}
}
