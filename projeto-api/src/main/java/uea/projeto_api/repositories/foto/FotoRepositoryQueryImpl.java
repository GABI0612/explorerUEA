package uea.projeto_api.repositories.foto;

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
import uea.projeto_api.dto.ResumoFotoDto;
import uea.projeto_api.models.Foto;
import uea.projeto_api.repositories.filters.FotoFilter;

public class FotoRepositoryQueryImpl 
implements FotoRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<ResumoFotoDto> filtrar(FotoFilter fotoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		
		CriteriaQuery<ResumoFotoDto> criteria = builder.createQuery(ResumoFotoDto.class);
		Root<Foto> root = criteria.from(Foto.class);
		
		criteria.select(builder.construct(ResumoFotoDto.class, root.get("codigo"),root.get("url"), root.get("descricao")));
		
		Predicate[] predicates = criarRestricoes(fotoFilter, builder, root);
		if (predicates.length > 0) {
			criteria.where(predicates);
		}
		
		TypedQuery<ResumoFotoDto> query = manager.createQuery(criteria);
		
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable,
				total(fotoFilter));
	}
	
	private Long total(FotoFilter fotoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Foto> root = criteria.from(Foto.class);

		Predicate[] predicates = criarRestricoes(fotoFilter, builder, root);
		if (predicates.length > 0) {
			criteria.where(predicates);
		}

		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<ResumoFotoDto> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalDeRegistroPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalDeRegistroPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalDeRegistroPorPagina);
	}

	private Predicate[] criarRestricoes(FotoFilter fotoFilter, CriteriaBuilder builder,
			Root<Foto> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!ObjectUtils.isEmpty(fotoFilter.getDescricao())) {
			predicates.add(builder.like(builder.lower(root.get("descricao")),
					"%" + fotoFilter.getDescricao().toLowerCase() + "%"));
		}

		

		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	

}