package org.palaasada.backend.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.palaasada.backend.model.User;
import org.palaasada.backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String authorizationHeader =
                request.getHeader("Authorization");

        System.out.println("Peticion: " + request.getRequestURI());
        System.out.println("Authorization: " + authorizationHeader);

        if (authorizationHeader == null ||
                !authorizationHeader.startsWith("Bearer ")) {

            System.out.println("No se encontro token JWT");

            filterChain.doFilter(request, response);
            return;
        }

        String token =
                authorizationHeader.substring(7);

        try {

            String correo =
                    jwtService.obtenerCorreo(token);

            System.out.println("Correo obtenido del token: " + correo);

            User usuario =
                    userRepository.findByCorreo(correo)
                            .orElse(null);

            if (usuario != null) {

                System.out.println("Usuario encontrado: "
                        + usuario.getNombre());

                String rol =
                        usuario.getRol().getNombre();

                System.out.println("Rol del usuario: " + rol);

                SimpleGrantedAuthority authority =
                        new SimpleGrantedAuthority("ROLE_" + rol);

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                usuario,
                                null,
                                List.of(authority)
                        );

                SecurityContextHolder
                        .getContext()
                        .setAuthentication(authentication);

                System.out.println("Usuario autenticado correctamente");

            } else {

                System.out.println("Usuario no encontrado");

            }

        } catch (Exception e) {

            System.out.println("Token invalido: "
                    + e.getMessage());

        }

        filterChain.doFilter(request, response);
    }
}