package uea.projeto_api.repositories.foto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uea.projeto_api.dto.ResumoFotoDto;
import uea.projeto_api.repositories.filters.FotoFilter;

public interface FotoRepositoryQuery {

	public Page<ResumoFotoDto> filtrar(
			FotoFilter fotoFilter, Pageable pageable);

}