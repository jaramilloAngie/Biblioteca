package edu.univalle.tecsoft.gestor_biblioteca.servicio.implementacion;

import edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades.Permiso;
import edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades.Rol;
import edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades.Usuario;
import edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades.UsuarioRol;
import edu.univalle.tecsoft.gestor_biblioteca.repositorio.UsuarioRepositorio;
import edu.univalle.tecsoft.gestor_biblioteca.repositorio.UsuarioRolRepositorio;
import edu.univalle.tecsoft.gestor_biblioteca.servicio.interfaces.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio implements IUsuarioServicio, UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepositorio usuarioRepositorio;
    private final UsuarioRolRepositorio usuarioRolRepositorio;

    @Autowired
    public UsuarioServicio(PasswordEncoder passwordEncoder, UsuarioRepositorio usuarioRepositorio,
                           UsuarioRolRepositorio usuarioRolRepositorio) {
        this.passwordEncoder = passwordEncoder;
        this.usuarioRepositorio = usuarioRepositorio;
        this.usuarioRolRepositorio = usuarioRolRepositorio;
    }

    @Override
    public List<Usuario> listar() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Usuario buscarPorId(Integer idUsuario) {
        return usuarioRepositorio.findById(idUsuario).orElse(null);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
        return usuarioRepositorio.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el correo: " + correo));

        List<GrantedAuthority> authorities = new ArrayList<>();

        List<UsuarioRol> usuarioRoles = usuarioRolRepositorio.findByUsuario_IdUsuario(usuario.getIdUsuario());
        for (UsuarioRol usuarioRol : usuarioRoles) {
            Rol rol = usuarioRol.getRol();
            authorities.add(new SimpleGrantedAuthority("ROLE_" + rol.getNombreRol()));

            rol.getRolPermisos().forEach(rolPermiso -> {
                Permiso permiso = rolPermiso.getPermiso();
                authorities.add(new SimpleGrantedAuthority(permiso.getNombrePermiso()));
            });
        }

        return new User(usuario.getCorreo(), usuario.getContraseña(), authorities);
    }

    public Optional<Usuario> buscarPorCorreo(String correo) {
        return usuarioRepositorio.findByCorreo(correo);
    }
}