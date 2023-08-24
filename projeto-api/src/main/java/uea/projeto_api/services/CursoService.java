package uea.projeto_api.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.projeto_api.models.Curso;
import uea.projeto_api.repositories.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	public Curso criar(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	public List<Curso> listar(){
		return cursoRepository.findAll();
	}
	
	public Curso buscarPorCodigo(Long codigo) {
		Curso curso = cursoRepository.findById(codigo).orElseThrow();
		return curso;
	}
	
	public void excluir(Long codigo) {
		cursoRepository.deleteById(codigo);
	}
	
	public Curso atualizar(Long codigo, Curso curso) {
		Curso cursoSalva = cursoRepository.
				findById(codigo).orElseThrow();
		BeanUtils.copyProperties(curso, cursoSalva, "codigo");
		return cursoRepository.save(cursoSalva);
	}
	

}