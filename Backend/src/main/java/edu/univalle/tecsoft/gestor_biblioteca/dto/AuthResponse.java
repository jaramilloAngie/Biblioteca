package edu.univalle.tecsoft.gestor_biblioteca.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"correo", "mensaje", "estado", "jwt", "roles", "permisos"})
public record AuthResponse(
        String correo,
        String mensaje,
        Boolean estado,
        String jwt,
        List<String> roles,
        List<String> permisos) {
}
