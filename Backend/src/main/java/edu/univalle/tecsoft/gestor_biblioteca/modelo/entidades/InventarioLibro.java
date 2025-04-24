package edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Inventario_Libro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InventarioLibro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario_libro")
    private Integer idInventarioLibro;

    @ManyToOne
    @JoinColumn(name = "id_libro", referencedColumnName = "id_libro", nullable = false)
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "id_biblioteca", referencedColumnName = "id_biblioteca", nullable = false)
    private Biblioteca biblioteca;

    @Column(name = "cantidad_total", nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer cantidadTotal;

    @Column(name = "cantidad_disponible", nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer cantidadDisponible;

    @Column(name = "activo", nullable = false, columnDefinition = "BIT DEFAULT 1")
    private Boolean activo;
}
