package org.palaasada.backend.controller;

import org.palaasada.backend.model.LoginRequest;
import org.palaasada.backend.model.User;
import org.palaasada.backend.model.Rol;
import org.palaasada.backend.repository.RolRepository;
import org.palaasada.backend.repository.UserRepository;
import org.palaasada.backend.service.UserService;
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
    private RolRepository rolRepository;

    @Autowired
    private UserService userService;

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
        respuesta.put("telefono", usuario.getTelefono());
        respuesta.put("rol", usuario.getRol() != null ? usuario.getRol().getNombre() : "CLIENTE");

        return ResponseEntity.ok(respuesta);
    }

    // Registro publico: siempre crea usuarios con rol CLIENTE
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User request) {

        if (request.getNombre() == null || request.getCorreo() == null
                || request.getTelefono() == null || request.getPassword() == null) {
            return ResponseEntity.badRequest()
                    .body("Faltan datos para el registro");
        }

        if (userRepository.findByCorreo(request.getCorreo()).isPresent()) {
            return ResponseEntity.status(409)
                    .body("Ya existe una cuenta con ese correo");
        }

        Rol rol = rolRepository.findByNombre("CLIENTE")
                .orElseGet(() -> rolRepository.save(new Rol(null, "CLIENTE")));

        User usuario = new User();
        usuario.setNombre(request.getNombre());
        usuario.setCorreo(request.getCorreo());
        usuario.setTelefono(request.getTelefono());
        usuario.setPassword(request.getPassword());
        usuario.setActivo(true);
        usuario.setRol(rol);

        userService.save(usuario);

        return login(new LoginRequest(request.getCorreo(), request.getPassword()));
    }
}
