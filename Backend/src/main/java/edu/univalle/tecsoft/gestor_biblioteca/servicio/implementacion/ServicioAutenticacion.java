package edu.univalle.tecsoft.gestor_biblioteca.servicio.implementacion;

import edu.univalle.tecsoft.gestor_biblioteca.dto.AuthResponse;
import edu.univalle.tecsoft.gestor_biblioteca.dto.AuthLoginRequest;
import edu.univalle.tecsoft.gestor_biblioteca.modelo.entidades.Usuario;
import edu.univalle.tecsoft.gestor_biblioteca.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioAutenticacion {

    private final AuthenticationManager authenticationManager;
    private final UsuarioServicio usuarioServicio; // Inyecta UsuarioServicio
    private final JwtUtil jwtUtil;

    @Autowired
    public ServicioAutenticacion(AuthenticationManager authenticationManager, UsuarioServicio usuarioServicio, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.usuarioServicio = usuarioServicio;
        this.jwtUtil = jwtUtil;
    }

    public AuthResponse loginUser(AuthLoginRequest authLoginRequest) {
        String correo = authLoginRequest.correo();
        String contraseña = authLoginRequest.contraseña();

        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(correo, contraseña)
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Credenciales incorrectas: ", e);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = usuarioServicio.loadUserByUsername(correo);
        Optional<Usuario> usuarioOptional = usuarioServicio.buscarPorCorreo(userDetails.getUsername());

        if (usuarioOptional.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado con el correo: " + correo);
        }
        Usuario usuario = usuarioOptional.get();

        String accessToken = jwtUtil.createToken(authentication);

        return new AuthResponse(correo, "Inicio de sesión satisfactorio", true, accessToken);
    }
}