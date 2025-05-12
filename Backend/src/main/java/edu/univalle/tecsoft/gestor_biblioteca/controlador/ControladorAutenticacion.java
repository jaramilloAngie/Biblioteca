package edu.univalle.tecsoft.gestor_biblioteca.controlador;

import edu.univalle.tecsoft.gestor_biblioteca.dto.AuthResponse;
import edu.univalle.tecsoft.gestor_biblioteca.dto.AuthLoginRequest;
import edu.univalle.tecsoft.gestor_biblioteca.servicio.implementacion.ServicioAutenticacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacion")
public class ControladorAutenticacion {

    private final ServicioAutenticacion servicioAutenticacion;

    @Autowired
    public ControladorAutenticacion(ServicioAutenticacion servicioAutenticacion) {
        this.servicioAutenticacion = servicioAutenticacion;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticateUser(@RequestBody AuthLoginRequest loginRequest) {
        AuthResponse authResponse = servicioAutenticacion.loginUser(loginRequest);
        return ResponseEntity.ok(authResponse);
    }
}