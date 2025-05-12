package edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Rol_Permiso")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@IdClass(RolPermisoId.class)
public class RolPermiso {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    private Rol rol;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_permiso", referencedColumnName = "id_permiso")
    private Permiso permiso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modulo", referencedColumnName = "id_modulo")
    private Modulo modulo;
}
