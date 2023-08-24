package uea.projeto_api.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.projeto_api.models.ColagemTematica;
import uea.projeto_api.repositories.ColagemTematicaRepository;

@Service
public class ColagemTematicaService {
	
	@Autowired
	private ColagemTematicaRepository colagemTematicaRepository;
	
	public ColagemTematica criar(ColagemTematica colagemTematica) {
		return colagemTematicaRepository.save(colagemTematica);
	}
	
	public List<ColagemTematica> listar(){
		return colagemTematicaRepository.findAll();
	}
	
	public ColagemTematica buscarPorCodigo(Long codigo) {
		ColagemTematica colagemTematica = colagemTematicaRepository.findById(codigo).orElseThrow();
		return colagemTematica;
	}
	
	public void excluir(Long codigo) {
		colagemTematicaRepository.deleteById(codigo);
	}
	
	public ColagemTematica atualizar(Long codigo, ColagemTematica colagemTematica) {
		ColagemTematica colagemTematicaSalva = colagemTematicaRepository.
				findById(codigo).orElseThrow();
		BeanUtils.copyProperties(colagemTematica, colagemTematicaSalva, "codigo");
		return colagemTematicaRepository.save(colagemTematicaSalva);
	}
	

}