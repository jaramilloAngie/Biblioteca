package edu.univalle.tecsoft.gestor_biblioteca.servicio.implementacion;

import edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades.Usuario;
import edu.univalle.tecsoft.gestor_biblioteca.repositorio.UsuarioRepositorio;
import edu.univalle.tecsoft.gestor_biblioteca.servicio.interfaces.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio implements IUsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<Usuario> listar() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Usuario buscarPorId(Integer idUsuario) {
        return usuarioRepositorio.findById(idUsuario).orElse(null);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }
}
