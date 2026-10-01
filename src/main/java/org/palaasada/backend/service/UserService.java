package org.palaasada.backend.service;

import org.palaasada.backend.model.User;
import org.palaasada.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    public User save(User user) {

        String passwordEncriptada =
                passwordEncoder.encode(user.getPassword());

        user.setPassword(passwordEncriptada);

        return userRepository.save(user);
    }

    public User update(Integer id, User user) {

        user.setId(id);

        String passwordEncriptada =
                passwordEncoder.encode(user.getPassword());

        user.setPassword(passwordEncriptada);

        return userRepository.save(user);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public boolean login(String correo, String password) {

        Optional<User> usuario = userRepository.findByCorreo(correo);

        if (usuario.isEmpty()) {
            return false;
        }

        return passwordEncoder.matches(
                password,
                usuario.get().getPassword()
        );
    }
}