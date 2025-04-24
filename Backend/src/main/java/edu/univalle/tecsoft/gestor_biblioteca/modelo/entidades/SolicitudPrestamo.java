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

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_inventario_libro", referencedColumnName = "id_inventario_libro", nullable = false)
    private InventarioLibro inventarioLibro;

    @Column(name = "fecha_solicitud", columnDefinition = "DATETIME DEFAULT GETDATE()")
    private LocalDateTime fechaSolicitud;

    @Column(name = "estado_solicitud", nullable = false, length = 20)
    private String estadoSolicitud;
}
