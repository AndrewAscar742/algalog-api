package br.com.sp.algalogapi.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sp.algalogapi.api.dto.ClienteDto;
import br.com.sp.algalogapi.api.dto.ReturnClienteDto;
import br.com.sp.algalogapi.domain.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<Page<ReturnClienteDto>> listarClientes(Pageable page) {
		return ResponseEntity.ok(clienteService.listarClientes(page));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> listarCliente(@PathVariable Long id) {
		return clienteService.listarCliente(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ReturnClienteDto cadastrarCliente(@RequestBody @Valid ClienteDto cliente) {
		return clienteService.cadastrarCliente(cliente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ReturnClienteDto> atualizarCliente(@PathVariable Long id, @RequestBody @Valid ClienteDto cliente) {
		return clienteService.atualizarCliente(id, cliente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
		return clienteService.excluirCliente(id);

	}
}
