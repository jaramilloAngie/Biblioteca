package edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode
public class RolPermisoId implements Serializable {
    private Integer rol;
    private Integer permiso;
}
