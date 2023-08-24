package uea.projeto_api.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.projeto_api.models.Publicacao;
import uea.projeto_api.repositories.PublicacaoRepository;

@Service
public class PublicacaoService {
	
	@Autowired
	private PublicacaoRepository publicacaoRepository;
	
	public Publicacao criar(Publicacao publicacao) {
		return publicacaoRepository.save(publicacao);
	}
	
	public List<Publicacao> listar(){
		return publicacaoRepository.findAll();
	}
	
	public Publicacao buscarPorCodigo(Long codigo) {
		Publicacao publicacao = publicacaoRepository.findById(codigo).orElseThrow();
		return publicacao;
	}
	
	public void excluir(Long codigo) {
		publicacaoRepository.deleteById(codigo);
	}
	
	public Publicacao atualizar(Long codigo, Publicacao publicacao) {
		Publicacao publicacaoSalva = publicacaoRepository.
				findById(codigo).orElseThrow();
		BeanUtils.copyProperties(publicacao, publicacaoSalva, "codigo");
		return publicacaoRepository.save(publicacaoSalva);
	}
	

}