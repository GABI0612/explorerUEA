package uea.projeto_api.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import uea.projeto_api.dto.ResumoFotoDto;
import uea.projeto_api.models.Foto;
import uea.projeto_api.repositories.FotoRepository;
import uea.projeto_api.repositories.filters.FotoFilter;

@Service
public class FotoService {
	
	@Autowired
	private FotoRepository fotoRepository;
	
	public Foto criar(Foto foto) {
		return fotoRepository.save(foto);
	}
	
	public Page<ResumoFotoDto> resumir(FotoFilter fotoFilter, Pageable pageable){
		return fotoRepository.filtrar(fotoFilter, pageable);
	}
	
	public Foto buscarPorCodigo(Long codigo) {
		Foto foto = fotoRepository.findById(codigo).orElseThrow();
		return foto;
	}
	
	public void excluir(Long codigo) {
		fotoRepository.deleteById(codigo);
	}
	
	public Foto atualizar(Long codigo, Foto foto) {
		Foto fotoSalva = fotoRepository.
				findById(codigo).orElseThrow();
		BeanUtils.copyProperties(foto, fotoSalva, "codigo");
		return fotoRepository.save(fotoSalva);
	}
	

}