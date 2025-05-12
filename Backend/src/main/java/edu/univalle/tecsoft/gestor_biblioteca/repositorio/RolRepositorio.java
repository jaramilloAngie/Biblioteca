package edu.univalle.tecsoft.gestor_biblioteca.repositorio;

import edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepositorio extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByNombreRol(String nombreRol);
}
