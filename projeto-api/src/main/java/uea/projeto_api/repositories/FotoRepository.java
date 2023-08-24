package uea.projeto_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uea.projeto_api.models.Foto;
import uea.projeto_api.repositories.foto.FotoRepositoryQuery;

@Repository
public interface FotoRepository  extends JpaRepository<Foto, Long>, FotoRepositoryQuery {

}