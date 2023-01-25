package br.com.sp.algalogapi.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sp.algalogapi.domain.model.Cliente;
import br.com.sp.algalogapi.domain.model.Entrega;
import br.com.sp.algalogapi.domain.model.StatusEntrega;
import br.com.sp.algalogapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {
	
	private ClienteService clienteService;
	private EntregaRepository repository;
	
	@Transactional
	public Entrega cadastrarEntrega(Entrega entrega) {
		Cliente cliente = clienteService.buscarCliente(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setData_pedido(LocalDateTime.now());
		repository.save(entrega);
		
		return entrega;
	}
}
