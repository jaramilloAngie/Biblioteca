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

    @Column(name = "nombre_biblioteca", unique = true, nullable = false)
    private String nombreBiblioteca;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "pais")
    private String pais;

    @OneToMany(mappedBy = "biblioteca")
    private List<InventarioLibro> inventarios;

    @ManyToMany
    @JoinTable(
            name = "Usuario_Biblioteca",
            joinColumns = @JoinColumn(name = "id_biblioteca"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario")
    )
    private List<Usuario> usuarios;
}
