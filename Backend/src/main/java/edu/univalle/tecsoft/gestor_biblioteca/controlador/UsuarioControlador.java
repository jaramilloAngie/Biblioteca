package edu.univalle.tecsoft.gestor_biblioteca.controlador;

import edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades.Usuario;
import edu.univalle.tecsoft.gestor_biblioteca.servicio.interfaces.IUsuarioServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:5173")
public class UsuarioControlador {
    private static final Logger logger = LoggerFactory.getLogger(UsuarioControlador.class);

    @Autowired
    private IUsuarioServicio usuarioServicio;

    @GetMapping("/usuarios")
    public List<Usuario> obtenerUsuarios(){
        var usuarios = usuarioServicio.listar();
        //Obtener la lista que se está iterando en la consola
        usuarios.forEach((usuario -> logger.info(usuario.toString())));
        return usuarios;
    }
}
