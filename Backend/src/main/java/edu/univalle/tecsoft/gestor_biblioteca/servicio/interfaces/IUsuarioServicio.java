package edu.univalle.tecsoft.gestor_biblioteca.servicio.interfaces;

import edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades.Usuario;

import java.util.List;

public interface IUsuarioServicio {
    public List<Usuario> listar();
    public Usuario buscarPorId(Integer idUsuario);
    public Usuario guardar(Usuario usuario);
}
