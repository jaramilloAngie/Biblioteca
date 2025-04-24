package edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Usuario_Biblioteca")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(UsuarioBibliotecaId.class)
public class UsuarioBiblioteca {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_biblioteca", nullable = false)
    private Biblioteca biblioteca;
}
