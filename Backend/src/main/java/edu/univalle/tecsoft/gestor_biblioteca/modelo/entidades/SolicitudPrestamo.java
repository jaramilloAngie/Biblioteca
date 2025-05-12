package edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "Solicitud_Prestamo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SolicitudPrestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private Integer idSolicitud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_libro_sede", nullable = false)
    private LibroSede libroSede;

    @Column(name = "fecha_solicitud")
    private LocalDateTime fechaSolicitud = LocalDateTime.now();

    @Column(name = "estado_solicitud", nullable = false)
    private String estadoSolicitud; // "Pendiente", "Aprobada", "Rechazada", "Cancelada"
}
