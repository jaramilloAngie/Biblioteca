package edu.univalle.tecsoft.gestor_biblioteca.configuracion.seguridad.filtro;

import com.auth0.jwt.interfaces.DecodedJWT;
import edu.univalle.tecsoft.gestor_biblioteca.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JwtTokenValidador extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    @Autowired
    public JwtTokenValidador(JwtUtil jwtUtils) {
        this.jwtUtil = jwtUtils;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");

        if (StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);

            try {
                DecodedJWT decodedJWT = jwtUtil.validateToken(token);

                if (decodedJWT != null) {
                    String username = jwtUtil.extractUsername(decodedJWT);
                    List<String> roles = jwtUtil.getRolesFromToken(decodedJWT);
                    List<String> permissions = jwtUtil.getPermissionsFromToken(decodedJWT);

                    List<GrantedAuthority> authorities = new ArrayList<>();
                    roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));
                    permissions.forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission)));

                    Authentication authenticationToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
                    SecurityContext context = SecurityContextHolder.createEmptyContext();
                    context.setAuthentication(authenticationToken);
                    SecurityContextHolder.setContext(context);

                } else {
                    System.out.println("Token inválido.");
                }
            } catch (Exception e) {
                System.out.println("Error durante la validación del token: " + e.getMessage());
            }
        }

        filterChain.doFilter(request, response);
    }
}