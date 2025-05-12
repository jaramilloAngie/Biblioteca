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
public class RolPermisoId implements Serializable {

    private Integer rol;
    private Integer permiso;
    private Integer modulo;
}
