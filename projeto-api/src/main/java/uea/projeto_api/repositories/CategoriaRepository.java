package uea.projeto_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uea.projeto_api.models.Categoria;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, Long> {

}