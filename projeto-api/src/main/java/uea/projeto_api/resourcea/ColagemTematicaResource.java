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
import uea.projeto_api.models.ColagemTematica;
import uea.projeto_api.services.ColagemTematicaService;

@RestController
@RequestMapping("/colagemTematicas")
public class ColagemTematicaResource {
	
	@Autowired
	private ColagemTematicaService colagemTematicaService;
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_COLAGEMTEMATICA') and hasAuthority('SCOPE_write')")
	public ResponseEntity<ColagemTematica> criar(@Valid @RequestBody ColagemTematica colagemTematica) {
		ColagemTematica colagemTematicaSalva = colagemTematicaService.criar(colagemTematica);
		
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{codigo}").
				buildAndExpand(colagemTematicaSalva.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(colagemTematicaSalva);
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_COLAGEMTEMATICA') and hasAuthority('SCOPE_read')" )
	public ResponseEntity<List<ColagemTematica>> listar() {
		List<ColagemTematica> colagemTematicas = colagemTematicaService.listar();
		return ResponseEntity.ok().body(colagemTematicas);
	}
	
	@GetMapping(value = "/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_COLAGEMTEMATICA') and hasAuthority('SCOPE_read')" )
	public ResponseEntity<ColagemTematica> buscarPorCodigo(@PathVariable 
			Long codigo){
		ColagemTematica colagemTematica = colagemTematicaService.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(colagemTematica);
	}
	
	@DeleteMapping(value="/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_REMOVER_COLAGEMTEMATICA') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Void> excluir(@PathVariable Long codigo){
		colagemTematicaService.excluir(codigo);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_ATUALIZAR_COLAGEMTEMATICA') and hasAuthority('SCOPE_write')")
	public ResponseEntity<ColagemTematica> atualizar(@PathVariable Long codigo,
			@Valid @RequestBody ColagemTematica colagemTematica){
		ColagemTematica colagemTematicaSalva = colagemTematicaService.atualizar(codigo,
				colagemTematica);
		return ResponseEntity.ok().body(colagemTematicaSalva);
		
	}
	
	
	
}