package br.com.sp.algalogapi.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sp.algalogapi.api.dto.input.EntregaDto;
import br.com.sp.algalogapi.api.dto.output.ReturnEntregaDto;
import br.com.sp.algalogapi.api.service.ModelMapperService;
import br.com.sp.algalogapi.domain.model.Cliente;
import br.com.sp.algalogapi.domain.model.Entrega;
import br.com.sp.algalogapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {
	
	private ClienteService clienteService;
	private EntregaRepository repository;
	private BuscaEntidadeService buscaEntidadeService;
	private ModelMapperService modelMapper;
	
	
	public Page<ReturnEntregaDto> listarEntregas(@PageableDefault() Pageable paginacao) {
		var page = repository.findAll(paginacao).map(entrega -> modelMapper.toReturnEntregaDto(entrega));
		return page;
	}
	
	public ResponseEntity<ReturnEntregaDto> listarEntrega(Long id) {
		return repository.findById(id).map(
				entrega -> (ResponseEntity.ok(modelMapper.toReturnEntregaDto(entrega)))
				).orElse(ResponseEntity.notFound().build());
	}
	
	@Transactional
	public ReturnEntregaDto cadastrarEntrega(EntregaDto entregaDto) {
		Cliente cliente = clienteService.buscarCliente(entregaDto.getCliente().getId());
		Entrega entrega = modelMapper.toModel(entregaDto);
		repository.save(entrega);
		
		ReturnEntregaDto returnEntrega = modelMapper.toReturnEntregaDto(entrega);
		returnEntrega.setCliente(modelMapper.toReturnClienteDto(cliente));
		
		return returnEntrega;
	}
	
	@Transactional
	public ResponseEntity<Void> finalizarEntrega(Long id) {
		Entrega entrega = buscaEntidadeService.retornarEntrega(id);
		entrega.finalizar();
		repository.save(entrega);
		
		return ResponseEntity.noContent().build();
		
	}

	
}
