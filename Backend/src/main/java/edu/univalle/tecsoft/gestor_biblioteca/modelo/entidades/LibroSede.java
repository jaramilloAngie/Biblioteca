package edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "Libro_Sede")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LibroSede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro_sede")
    private Integer idLibroSede;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_referencia_libro", nullable = false)
    private ReferenciaLibro referenciaLibro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sede", nullable = false)
    private Sede sede;

    @Column(name = "ISBN", nullable = false, unique = true)
    private String isbn;

    @Column(name = "activo", nullable = false)
    private boolean activo = true;

    @OneToMany(mappedBy = "libroSede", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SolicitudPrestamo> solicitudPrestamos;

    @OneToMany(mappedBy = "libroSede", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Prestamo> prestamos;
}
