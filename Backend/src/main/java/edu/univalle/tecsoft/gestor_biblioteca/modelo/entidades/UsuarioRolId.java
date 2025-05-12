package edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Embeddable
public class UsuarioRolId implements Serializable {

    private Integer usuario;
    private Integer rol;
}
