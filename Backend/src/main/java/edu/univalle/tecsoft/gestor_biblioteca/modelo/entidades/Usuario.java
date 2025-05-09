package edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "correo", unique = true, nullable = false)
    private String correo;

    @Column(name = "contraseña", nullable = false)
    private String contraseña;

    @Column(name = "fecha_registro", columnDefinition = "DATETIME DEFAULT GETDATE()")
    private LocalDateTime fechaRegistro;

    @Column(name = "activo", nullable = false, columnDefinition = "BIT DEFAULT 1")
    private Boolean activo;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioRol> usuarioRoles;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioBiblioteca> usuarioBibliotecas;

    @OneToMany(mappedBy = "usuario")
    private List<SolicitudPrestamo> solicitudesPrestamo;

    @OneToMany(mappedBy = "usuario")
    private List<Prestamo> prestamos;
}
