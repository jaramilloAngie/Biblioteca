package edu.univalle.tecsoft.gestor_biblioteca.repositorio;

import edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BibliotecaRepositorio extends JpaRepository<Biblioteca, Integer> {
    Optional<Biblioteca> findByNombreBiblioteca(String nombreBiblioteca);
}
