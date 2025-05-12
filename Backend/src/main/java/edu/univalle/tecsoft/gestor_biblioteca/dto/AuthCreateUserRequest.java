package edu.univalle.tecsoft.gestor_biblioteca.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

public record AuthCreateUserRequest(
        @NotBlank @Email String correo,
        @NotBlank @Size(min = 6) String contraseña,
        List<String> roleRequest
) {
}