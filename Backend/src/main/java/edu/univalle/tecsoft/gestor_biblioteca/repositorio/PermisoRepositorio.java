package edu.univalle.tecsoft.gestor_biblioteca.repositorio;

import edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermisoRepositorio extends JpaRepository<Permiso, Integer> {
    Optional<Permiso> findByNombrePermiso(String nombrePermiso);
}
