package edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "Referencia_Libro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReferenciaLibro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_referencia_libro")
    private Integer idReferenciaLibro;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "editorial")
    private String editorial;

    @Column(name = "año_publicacion")
    private Short añoPublicacion;

    @Column(name = "edicion")
    private String edicion;

    @OneToMany(mappedBy = "referenciaLibro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LibroSede> librosSede;
}
