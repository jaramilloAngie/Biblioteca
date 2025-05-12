package edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "Modulo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modulo")
    private Integer idModulo;

    @Column(name = "nombre_modulo", nullable = false, unique = true)
    private String nombreModulo;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "modulo", fetch = FetchType.LAZY)
    private List<RolPermiso> rolPermisos;
}
