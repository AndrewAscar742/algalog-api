package br.com.sp.algalogapi.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sp.algalogapi.api.dto.EntregaDto;
import br.com.sp.algalogapi.api.dto.ReturnEntregaDto;
import br.com.sp.algalogapi.domain.model.Cliente;
import br.com.sp.algalogapi.domain.model.Entrega;
import br.com.sp.algalogapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {
	
	private ClienteService clienteService;
	private EntregaRepository repository;
	
	
	public Page<ReturnEntregaDto> listarEntregas(@PageableDefault() Pageable paginacao) {
		var page = repository.findAll(paginacao).map(ReturnEntregaDto::new);
		return page;
	}
	
	public ResponseEntity<ReturnEntregaDto> listarEntrega(Long id) {
		return repository.findById(id).map(
				entrega -> (ResponseEntity.ok(new ReturnEntregaDto(entrega)))
				).orElse(ResponseEntity.notFound().build());
	}
	
	@Transactional
	public Entrega cadastrarEntrega(EntregaDto entregaDto) {
		Cliente cliente = clienteService.buscarCliente(entregaDto.cliente().getId());
		Entrega entrega = new Entrega(entregaDto, cliente);
		repository.save(entrega);
		
		return entrega;
	}

	
}
