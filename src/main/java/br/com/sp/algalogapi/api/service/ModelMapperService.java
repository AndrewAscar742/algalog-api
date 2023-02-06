package br.com.sp.algalogapi.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sp.algalogapi.api.dto.input.ClienteDto;
import br.com.sp.algalogapi.api.dto.input.EntregaDto;
import br.com.sp.algalogapi.api.dto.output.PostOcorrenciaDto;
import br.com.sp.algalogapi.api.dto.output.ReturnClienteDto;
import br.com.sp.algalogapi.api.dto.output.ReturnEntregaDto;
import br.com.sp.algalogapi.api.dto.output.ReturnOcorrenciaDto;
import br.com.sp.algalogapi.domain.model.Cliente;
import br.com.sp.algalogapi.domain.model.Entrega;
import br.com.sp.algalogapi.domain.model.Ocorrencia;

@Component
public class ModelMapperService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ReturnEntregaDto toReturnEntregaDto(Entrega entrega) {
		return modelMapper.map(entrega, ReturnEntregaDto.class);
	}
	
	public ReturnClienteDto toReturnClienteDto(Cliente cliente) {
		return modelMapper.map(cliente, ReturnClienteDto.class);
	}
	
	public Entrega toModel(EntregaDto entregaDto) {
		return modelMapper.map(entregaDto, Entrega.class);
		
	}

	public Cliente toCliente(ClienteDto clienteDto) {
		return modelMapper.map(clienteDto, Cliente.class);
	}
	
	public PostOcorrenciaDto toPostOcorrenciaDto(Ocorrencia ocorrencia) {
		return modelMapper.map(ocorrencia, PostOcorrenciaDto.class);
	}

	public List<ReturnOcorrenciaDto> toListReturnOcorrencia(List<Ocorrencia> ocorrencias) {
		return ocorrencias.stream()
				.map(this::toReturnOcorrenciaDto)
				.collect(Collectors.toList());
	}
	
	private ReturnOcorrenciaDto toReturnOcorrenciaDto(Ocorrencia ocorrencia) {
		return modelMapper.map(ocorrencia, ReturnOcorrenciaDto.class);
	}


}
