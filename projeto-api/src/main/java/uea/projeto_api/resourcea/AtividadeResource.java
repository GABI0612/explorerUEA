package uea.projeto_api.resourcea;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import uea.projeto_api.dto.ResumoAtividadeDto;
import uea.projeto_api.models.Atividade;
import uea.projeto_api.repositories.filters.AtividadeFilter;
import uea.projeto_api.services.AtividadeService;

@RestController
@RequestMapping("/atividades")
public class AtividadeResource {

	@Autowired
	private AtividadeService atividadeService;

	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_ATIVIDADE') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Atividade> criar(@Valid @RequestBody Atividade atividade) {
		Atividade atividadeSalva = atividadeService.criar(atividade);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}")
				.buildAndExpand(atividadeSalva.getCodigo()).toUri();

		return ResponseEntity.created(uri).body(atividadeSalva);
	}

	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_ATIVIDADE') and hasAuthority('SCOPE_read')")
	public ResponseEntity<Page<ResumoAtividadeDto>> resumir(AtividadeFilter atividadeFilter, Pageable pageable) {
		Page<ResumoAtividadeDto> resumos = atividadeService.resumir(atividadeFilter, pageable);
		return ResponseEntity.ok().body(resumos);
	}

	@GetMapping(value = "/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_ATIVIDADE') and hasAuthority('SCOPE_read')")
	public ResponseEntity<Atividade> buscarPorCodigo(@PathVariable Long codigo) {
		Atividade atividade = atividadeService.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(atividade);
	}

	@DeleteMapping(value = "/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_REMOVER_ATIVIDADE') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Void> excluir(@PathVariable Long codigo) {
		atividadeService.excluir(codigo);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_ATUALIZAR_ATIVIDADE') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Atividade> atualizar(@PathVariable Long codigo, @Valid @RequestBody Atividade atividade) {
		Atividade atividadeSalva = atividadeService.atualizar(codigo, atividade);
		return ResponseEntity.ok().body(atividadeSalva);

	}

}