package br.com.sp.algalogapi.domain.service;

import org.springframework.stereotype.Service;

import br.com.sp.algalogapi.domain.exception.EntidadeNaoEncontradaException;
import br.com.sp.algalogapi.domain.model.Entrega;
import br.com.sp.algalogapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BuscaEntidadeService {
	
	private EntregaRepository entregaRepository;	
	
	public Entrega retornarEntrega(Long id) {
		return entregaRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}
}
