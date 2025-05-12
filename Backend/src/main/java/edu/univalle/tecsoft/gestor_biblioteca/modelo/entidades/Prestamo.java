package edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "Prestamo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestamo")
    private Integer idPrestamo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_libro_sede", nullable = false)
    private LibroSede libroSede;

    @Column(name = "fecha_prestamo")
    private LocalDateTime fechaPrestamo = LocalDateTime.now();

    @Column(name = "fecha_devolucion_esperada", nullable = false)
    private LocalDateTime fechaDevolucionEsperada;

    @Column(name = "fecha_devolucion_real")
    private LocalDateTime fechaDevolucionReal;

    @Column(name = "estado_prestamo", nullable = false)
    private String estadoPrestamo; // "Activo", "Devuelto", "Vencido", "Extendido"
}
