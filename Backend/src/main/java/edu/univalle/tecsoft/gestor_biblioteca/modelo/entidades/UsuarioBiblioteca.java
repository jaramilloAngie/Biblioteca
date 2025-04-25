package edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Usuario_Biblioteca")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioBiblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_biblioteca")
    private Integer idUsuarioBiblioteca;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_biblioteca", nullable = false)
    private Biblioteca biblioteca;
}
