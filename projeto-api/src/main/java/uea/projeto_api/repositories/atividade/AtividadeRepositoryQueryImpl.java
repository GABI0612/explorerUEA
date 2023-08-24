package uea.projeto_api.repositories.atividade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import uea.projeto_api.dto.ResumoAtividadeDto;
import uea.projeto_api.models.Atividade;
import uea.projeto_api.repositories.filters.AtividadeFilter;

public class AtividadeRepositoryQueryImpl 
implements AtividadeRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<ResumoAtividadeDto> filtrar(AtividadeFilter atividadeFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		
		CriteriaQuery<ResumoAtividadeDto> criteria = builder.createQuery(ResumoAtividadeDto.class);
		Root<Atividade> root = criteria.from(Atividade.class);
		
		criteria.select(builder.construct(ResumoAtividadeDto.class, root.get("codigo"),root.get("titulo"), root.get("descricao"),
				root.get("data"), 
				root.get("categoria").get("nome"), root.get("usuario").get("nome"), root.get("publicacao").get("descricao")));
		
		Predicate[] predicates = criarRestricoes(atividadeFilter, builder, root);
		if (predicates.length > 0) {
			criteria.where(predicates);
		}
		
		TypedQuery<ResumoAtividadeDto> query = manager.createQuery(criteria);
		
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable,
				total(atividadeFilter));
	}
	
	private Long total(AtividadeFilter atividadeFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Atividade> root = criteria.from(Atividade.class);

		Predicate[] predicates = criarRestricoes(atividadeFilter, builder, root);
		if (predicates.length > 0) {
			criteria.where(predicates);
		}

		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<ResumoAtividadeDto> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalDeRegistroPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalDeRegistroPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalDeRegistroPorPagina);
	}

	private Predicate[] criarRestricoes(AtividadeFilter atividadeFilter, CriteriaBuilder builder,
			Root<Atividade> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!ObjectUtils.isEmpty(atividadeFilter.getTitulo())) {
			predicates.add(builder.like(builder.lower(root.get("titulo")),
					"%" + atividadeFilter.getTitulo().toLowerCase() + "%"));
		}

		if (atividadeFilter.getDataDe() != null) {
			predicates.add(
					builder.greaterThanOrEqualTo(root.get("data"), atividadeFilter.getDataDe()));
		}

		if (atividadeFilter.getDataAte() != null) {
			predicates.add(
					builder.lessThanOrEqualTo(root.get("data"), atividadeFilter.getDataAte()));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	

}