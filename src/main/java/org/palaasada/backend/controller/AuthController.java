package org.palaasada.backend.controller;

import org.palaasada.backend.model.LoginRequest;
import org.palaasada.backend.model.User;
import org.palaasada.backend.repository.UserRepository;
import org.palaasada.backend.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        User usuario = userRepository
                .findByCorreo(request.getCorreo())
                .orElse(null);

        if (usuario == null) {
            return ResponseEntity.status(401)
                    .body("Correo o contraseña incorrectos");
        }

        if (!usuario.getActivo()) {
            return ResponseEntity.status(401)
                    .body("El usuario está inactivo");
        }

        if (!passwordEncoder.matches(
                request.getPassword(),
                usuario.getPassword())) {

            return ResponseEntity.status(401)
                    .body("Correo o contraseña incorrectos");
        }

        String token = jwtService.generarToken(usuario);

        Map<String, Object> respuesta = new HashMap<>();

        respuesta.put("mensaje", "Login exitoso");
        respuesta.put("token", token);
        respuesta.put("usuario", usuario.getNombre());
        respuesta.put("correo", usuario.getCorreo());
        respuesta.put("rol", usuario.getRol().getNombre());

        return ResponseEntity.ok(respuesta);
    }
}