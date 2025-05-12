package edu.univalle.tecsoft.gestor_biblioteca.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequest(@NotBlank String correo,
                               @NotBlank String contraseña) {
}
