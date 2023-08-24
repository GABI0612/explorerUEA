package uea.projeto_api.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import uea.projeto_api.dto.ResumoAtividadeDto;
import uea.projeto_api.models.Atividade;
import uea.projeto_api.repositories.AtividadeRepository;
import uea.projeto_api.repositories.filters.AtividadeFilter;

@Service
public class AtividadeService {
	
	@Autowired
	private AtividadeRepository atividadeRepository;
	
	
	public Page<ResumoAtividadeDto> resumir(AtividadeFilter atividadeFilter,
			Pageable pageable){
		return atividadeRepository.filtrar(atividadeFilter, pageable);
	}
	
	public Atividade criar(Atividade atividade) {
		return atividadeRepository.save(atividade);
	}
	
	public List<Atividade> listar(){
		return atividadeRepository.findAll();
	}
	
	public Atividade buscarPorCodigo(Long codigo) {
		Atividade atividade = atividadeRepository.findById(codigo).orElseThrow();
		return atividade;
	}
	
	public void excluir(Long codigo) {
		atividadeRepository.deleteById(codigo);
	}
	
	public Atividade atualizar(Long codigo, Atividade atividade) {
		Atividade atividadeSalvo = atividadeRepository.
				findById(codigo).orElseThrow();
		
		BeanUtils.copyProperties(atividade, atividadeSalvo, "codigo");
		return atividadeRepository.save(atividadeSalvo);
	}
	

}