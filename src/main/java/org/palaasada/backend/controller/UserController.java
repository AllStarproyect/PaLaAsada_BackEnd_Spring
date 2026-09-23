package org.palaasada.backend.controller;

import org.palaasada.backend.model.User;
import org.palaasada.backend.service.UserService; // O tu repositorio si no usas servicio aún
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") // Permite peticiones desde el frontend
public class UserController {

    @Autowired
    private UserService userService; // O UserRepository directamente si aplican servicio más adelante

    // ... aquí van los métodos del CRUD

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
