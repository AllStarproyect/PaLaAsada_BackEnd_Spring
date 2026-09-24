package org.palaasada.backend.service;

import org.palaasada.backend.model.Categoria;
import org.palaasada.backend.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> findById(Integer id) {
        return categoriaRepository.findById(id);
    }

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Integer id, Categoria categoria) {
        categoria.setCategoriaId(id);
        return categoriaRepository.save(categoria);
    }

    public void delete(Integer id) {
        categoriaRepository.deleteById(id);
    }
}