package edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode
public class UsuarioBibliotecaId implements Serializable {
    private Integer usuario;
    private Integer biblioteca;
}
