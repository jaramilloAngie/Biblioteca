package edu.univalle.tecsoft.gestor_biblioteca.repositorio;

import edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedeRepositorio extends JpaRepository<Sede, Integer> {
}
