package edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "Biblioteca")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_biblioteca")
    private Integer idBiblioteca;

    @Column(name = "nombre_biblioteca", nullable = false, unique = true)
    private String nombreBiblioteca;

    @Column(name = "nit", unique = true)
    private String nit;

    @Column(name = "nombre_responsable")
    private String nombreResponsable;

    @Column(name = "documento_responsable", unique = true)
    private String documentoResponsable;

    @OneToMany(mappedBy = "biblioteca", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sede> sedes;
}
