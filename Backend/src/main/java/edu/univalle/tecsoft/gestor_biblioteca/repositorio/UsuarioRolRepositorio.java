package edu.univalle.tecsoft.gestor_biblioteca.repositorio;

import edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades.UsuarioRol;
import edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades.UsuarioRolId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRolRepositorio extends JpaRepository<UsuarioRol, UsuarioRolId> {
    List<UsuarioRol> findByUsuario_IdUsuario(Integer usuarioId);
    List<UsuarioRol> findByRol_IdRol(Integer rolId);
}
