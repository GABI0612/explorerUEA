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
import uea.projeto_api.dto.ResumoFotoDto;
import uea.projeto_api.models.Foto;
import uea.projeto_api.repositories.filters.FotoFilter;
import uea.projeto_api.services.FotoService;

@RestController
@RequestMapping("/fotos")
public class FotoResource {
	
	@Autowired
	private FotoService fotoService;
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_FOTO') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Foto> criar(@Valid @RequestBody Foto foto) {
		Foto fotoSalva = fotoService.criar(foto);
		
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{codigo}").
				buildAndExpand(fotoSalva.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(fotoSalva);
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_FOTO') and hasAuthority('SCOPE_read')" )
	public ResponseEntity<Page<ResumoFotoDto>> resumir(FotoFilter fotoFilter, Pageable pageable) {
		Page<ResumoFotoDto> resumos = fotoService.resumir(fotoFilter, pageable);
		return ResponseEntity.ok().body(resumos);
	}
	
	@GetMapping(value = "/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_FOTO') and hasAuthority('SCOPE_read')" )
	public ResponseEntity<Foto> buscarPorCodigo(@PathVariable 
			Long codigo){
		Foto foto = fotoService.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(foto);
	}
	
	@DeleteMapping(value="/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_REMOVER_FOTO') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Void> excluir(@PathVariable Long codigo){
		fotoService.excluir(codigo);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_ATUALIZAR_FOTO') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Foto> atualizar(@PathVariable Long codigo,
			@Valid @RequestBody Foto foto){
		Foto fotoSalva = fotoService.atualizar(codigo,
				foto);
		return ResponseEntity.ok().body(fotoSalva);
		
	}
	
	
	
}