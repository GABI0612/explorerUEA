package uea.projeto_api.repositories.atividade;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uea.projeto_api.dto.ResumoAtividadeDto;
import uea.projeto_api.repositories.filters.AtividadeFilter;

public interface AtividadeRepositoryQuery {

	public Page<ResumoAtividadeDto> filtrar(
			AtividadeFilter atividadeFilter, Pageable pageable);

}