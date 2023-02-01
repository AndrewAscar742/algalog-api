package br.com.sp.algalogapi.api.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sp.algalogapi.api.dto.input.EntregaDto;
import br.com.sp.algalogapi.api.dto.output.ReturnEntregaDto;
import br.com.sp.algalogapi.domain.model.Entrega;
import br.com.sp.algalogapi.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor //injeção de dependencias pelo construtor
@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	private SolicitacaoEntregaService service;
	
	
	@GetMapping
	public Page<ReturnEntregaDto> listarEntregas(Pageable page) {
		return service.listarEntregas(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ReturnEntregaDto> listarEntrega(@PathVariable Long id) {
		return service.listarEntrega(id);
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ReturnEntregaDto cadastrarEntrega(@Valid @RequestBody EntregaDto entrega) {
		return service.cadastrarEntrega(entrega);
	}
	
	
}
