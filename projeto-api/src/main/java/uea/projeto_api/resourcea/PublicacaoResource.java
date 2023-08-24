package uea.projeto_api.resourcea;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import uea.projeto_api.models.Publicacao;
import uea.projeto_api.services.PublicacaoService;

@RestController
@RequestMapping("/publicacoes")
public class PublicacaoResource {
	
	@Autowired
	private PublicacaoService publicacaoService;
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PUBLICACAO') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Publicacao> criar(@Valid @RequestBody Publicacao publicacao) {
		Publicacao publicacaoSalva = publicacaoService.criar(publicacao);
		
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{codigo}").
				buildAndExpand(publicacaoSalva.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(publicacaoSalva);
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_PUBLICACAO') and hasAuthority('SCOPE_read')" )
	public ResponseEntity<List<Publicacao>> listar() {
		List<Publicacao> publicacaos = publicacaoService.listar();
		return ResponseEntity.ok().body(publicacaos);
	}
	
	@GetMapping(value = "/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_PUBLICACAO') and hasAuthority('SCOPE_read')" )
	public ResponseEntity<Publicacao> buscarPorCodigo(@PathVariable 
			Long codigo){
		Publicacao publicacao = publicacaoService.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(publicacao);
	}
	
	@DeleteMapping(value="/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_REMOVER_PUBLICACAO') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Void> excluir(@PathVariable Long codigo){
		publicacaoService.excluir(codigo);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_ATUALIZAR_PUBLICACAO') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Publicacao> atualizar(@PathVariable Long codigo,
			@Valid @RequestBody Publicacao publicacao){
		Publicacao publicacaoSalva = publicacaoService.atualizar(codigo,
				publicacao);
		return ResponseEntity.ok().body(publicacaoSalva);
		
	}
	
	
	
}