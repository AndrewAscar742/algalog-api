package br.com.sp.algalogapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sp.algalogapi.api.dto.ClienteDto;
import br.com.sp.algalogapi.api.dto.ReturnClienteDto;
import br.com.sp.algalogapi.domain.exception.NegocioException;
import br.com.sp.algalogapi.domain.model.Cliente;
import br.com.sp.algalogapi.domain.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	

	public Page<ReturnClienteDto> listarClientes(@PageableDefault() Pageable paginacao) {
		var page = repository.findAll(paginacao).map(ReturnClienteDto::new);
		return page;
	}
	
	//Utilizado no Controller
	public ResponseEntity<ClienteDto> listarCliente(Long id) {
		var cliente = repository.findById(id)
				.map(c -> ResponseEntity.ok(new ClienteDto(c)))
				.orElse(ResponseEntity.notFound().build());

		return cliente;

	}
	//Utilizado por outros services
	public Cliente buscarCliente(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
	}

	@Transactional
	public ReturnClienteDto cadastrarCliente(ClienteDto clienteDto) {
		validarEmail(clienteDto);

		var cliente = new Cliente(clienteDto);
		repository.save(cliente);
		
		return new ReturnClienteDto(cliente);
	}

	@Transactional
	public ResponseEntity<ReturnClienteDto> atualizarCliente(Long id, ClienteDto clienteDto) {
		if (!repository.existsById(id))
			return ResponseEntity.notFound().build();
		
		validarEmail(clienteDto);
		var cliente = new Cliente(clienteDto);
		cliente.setId(id);
		repository.save(cliente);
		
		return ResponseEntity.ok(new ReturnClienteDto(cliente));
	}

	@Transactional
	public ResponseEntity<Void> excluirCliente(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}

	private void validarEmail(ClienteDto clienteDto) {
		boolean emailEmUso = repository.findByEmail(clienteDto.email())
				.stream()
				.anyMatch(clienteSGDB -> !clienteSGDB.equals(new Cliente(clienteDto)));
		
		if (emailEmUso) 
			throw new NegocioException("E-mail em uso, tente novamente!");


	}
}
