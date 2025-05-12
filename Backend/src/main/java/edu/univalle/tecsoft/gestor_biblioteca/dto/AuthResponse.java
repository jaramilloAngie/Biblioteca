package edu.univalle.tecsoft.gestor_biblioteca.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"correo", "mensaje", "estado", "jwt"})
public record AuthResponse(
        String correo,
        String mensaje,
        Boolean estado,
        String jwt) {
}
