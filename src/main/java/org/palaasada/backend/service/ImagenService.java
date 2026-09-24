package org.palaasada.backend.service;

import org.palaasada.backend.model.Imagen;
import org.palaasada.backend.repository.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagenService {

    @Autowired
    private ImagenRepository imagenRepository;

    public List<Imagen> findAll() {
        return imagenRepository.findAll();
    }

    public Optional<Imagen> findById(String id) {
        return imagenRepository.findById(id);
    }

    public Imagen save(Imagen imagen) {
        return imagenRepository.save(imagen);
    }

    public Imagen update(String id, Imagen imagen) {
        imagen.setImagenId(id);
        return imagenRepository.save(imagen);
    }

    public void delete(String id) {
        imagenRepository.deleteById(id);
    }
}