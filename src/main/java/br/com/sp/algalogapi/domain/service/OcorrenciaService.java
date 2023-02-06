package br.com.sp.algalogapi.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.sp.algalogapi.api.dto.output.PostOcorrenciaDto;
import br.com.sp.algalogapi.api.dto.output.ReturnOcorrenciaDto;
import br.com.sp.algalogapi.api.service.ModelMapperService;
import br.com.sp.algalogapi.domain.model.Entrega;
import br.com.sp.algalogapi.domain.model.Ocorrencia;
import br.com.sp.algalogapi.domain.repository.OcorrenciaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OcorrenciaService {
	
	private OcorrenciaRepository ocorrenciaRepository;
	private BuscaEntidadeService buscaEntidadeService;
	private ModelMapperService modelMapper;
	
	public List<ReturnOcorrenciaDto> listarOcorrencias(Long id) {
		Entrega entrega = buscaEntidadeService.retornarEntrega(id);
		return modelMapper.toListReturnOcorrencia(entrega.getOcorrencias());
	}
			
	@Transactional
	public PostOcorrenciaDto registrarOcorrencia(Long id, String descricao) {
		Entrega entrega =  buscaEntidadeService.retornarEntrega(id);
		Ocorrencia ocorrencia = entrega.adicionarOcorrencia(descricao);
		ocorrenciaRepository.save(ocorrencia);
		PostOcorrenciaDto dto = modelMapper.toPostOcorrenciaDto(ocorrencia);
		
		return dto;
	}

	
}
