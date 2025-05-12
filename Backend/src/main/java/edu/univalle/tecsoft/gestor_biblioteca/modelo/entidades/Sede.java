package edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "Sede")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sede")
    private Integer idSede;

    @Column(name = "nombre_sede", nullable = false)
    private String nombreSede;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "pais")
    private String pais;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_biblioteca", nullable = false)
    private Biblioteca biblioteca;

    @OneToMany(mappedBy = "sede", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LibroSede> librosSede;

    @OneToMany(mappedBy = "sede", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Usuario> usuarios;
}
