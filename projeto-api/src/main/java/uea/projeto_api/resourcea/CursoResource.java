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
import uea.projeto_api.models.Curso;
import uea.projeto_api.services.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoResource {
	
	@Autowired
	private CursoService cursoService;
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CURSO') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Curso> criar(@Valid @RequestBody Curso curso) {
		Curso cursoSalva = cursoService.criar(curso);
		
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{codigo}").
				buildAndExpand(cursoSalva.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(cursoSalva);
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CURSO') and hasAuthority('SCOPE_read')" )
	public ResponseEntity<List<Curso>> listar() {
		List<Curso> cursos = cursoService.listar();
		return ResponseEntity.ok().body(cursos);
	}
	
	@GetMapping(value = "/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CURSO') and hasAuthority('SCOPE_read')" )
	public ResponseEntity<Curso> buscarPorCodigo(@PathVariable 
			Long codigo){
		Curso curso = cursoService.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(curso);
	}
	
	@DeleteMapping(value="/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_REMOVER_CURSO') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Void> excluir(@PathVariable Long codigo){
		cursoService.excluir(codigo);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_ATUALIZAR_CURSO') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Curso> atualizar(@PathVariable Long codigo,
			@Valid @RequestBody Curso curso){
		Curso cursoSalva = cursoService.atualizar(codigo,
				curso);
		return ResponseEntity.ok().body(cursoSalva);
		
	}
	
	
	
}