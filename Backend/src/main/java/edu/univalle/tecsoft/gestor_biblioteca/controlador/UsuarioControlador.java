package edu.univalle.tecsoft.gestor_biblioteca.controlador;

import edu.univalle.tecsoft.gestor_biblioteca.dto.AuthResponse;
import edu.univalle.tecsoft.gestor_biblioteca.dto.RegistroRequest;
import edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades.Usuario;
import edu.univalle.tecsoft.gestor_biblioteca.servicio.implementacion.UsuarioServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    @Autowired
    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @PostMapping("/registrar-lector")
    public ResponseEntity<?> registrarLector(@RequestBody @Valid RegistroRequest registroRequest) {
        try {
            Usuario nuevoUsuario = usuarioServicio.registrarLector(
                    registroRequest.nombre(),
                    registroRequest.apellido(),
                    registroRequest.correo(),
                    registroRequest.contraseña(),
                    registroRequest.sedeId()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario lector registrado exitosamente.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno al registrar usuario.");
        }
    }
}
