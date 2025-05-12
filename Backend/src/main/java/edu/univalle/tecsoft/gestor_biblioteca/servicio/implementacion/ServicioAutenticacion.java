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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicioAutenticacion {

    private final AuthenticationManager authenticationManager;
    private final UsuarioServicio usuarioServicio;
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
            Optional<Usuario> usuarioOptional = usuarioServicio.buscarPorCorreo(correo);
            String mensajeError = usuarioOptional.isPresent() ? "La contraseña es incorrecta." : "El correo electrónico ingresado no existe.";
            return new AuthResponse(correo, mensajeError, false, null, null, null);
        } catch (UsernameNotFoundException e) {
            return new AuthResponse(correo, "El correo electrónico ingresado no existe.", false, null, null, null);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = usuarioServicio.loadUserByUsername(correo);
        Optional<Usuario> usuarioOptional = usuarioServicio.buscarPorCorreo(userDetails.getUsername());

        if (usuarioOptional.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado con el correo: " + correo);
        }
        Usuario usuario = usuarioOptional.get();

        String accessToken = jwtUtil.createToken(authentication);

        List<String> roles = authentication.getAuthorities().stream()
                .filter(auth -> auth.getAuthority().startsWith("ROLE_"))
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        List<String> permisos = authentication.getAuthorities().stream()
                .filter(auth -> !auth.getAuthority().startsWith("ROLE_"))
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return new AuthResponse(correo, "Inicio de sesión satisfactorio", true, accessToken, roles, permisos);
    }
}