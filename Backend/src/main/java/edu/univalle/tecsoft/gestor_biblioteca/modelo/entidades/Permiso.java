package edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "Permiso")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permiso")
    private Integer idPermiso;

    @Column(name = "modulo", nullable = false)
    private String modulo;

    @Column(name = "accion", nullable = false)
    private String accion;

    @ManyToMany(mappedBy = "permisos")
    private List<Rol> roles;
}
