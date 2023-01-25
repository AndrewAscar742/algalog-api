package br.com.sp.algalogapi.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sp.algalogapi.domain.model.Entrega;
import br.com.sp.algalogapi.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor //injeção de dependencias pelo construtor
@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	private SolicitacaoEntregaService service;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Entrega cadastrarEntrega(@RequestBody Entrega entrega) {
		return service.cadastrarEntrega(entrega);
	}
}
