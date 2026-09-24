package org.palaasada.backend.service;

import org.palaasada.backend.model.CondicionComercial;
import org.palaasada.backend.repository.CondicionComercialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CondicionComercialService {

    @Autowired
    private CondicionComercialRepository condicionComercialRepository;

    public List<CondicionComercial> findAll() {
        return condicionComercialRepository.findAll();
    }

    public Optional<CondicionComercial> findById(Integer id) {
        return condicionComercialRepository.findById(id);
    }

    public CondicionComercial save(CondicionComercial condicion) {
        return condicionComercialRepository.save(condicion);
    }

    public CondicionComercial update(
            Integer id,
            CondicionComercial condicion) {

        condicion.setCondicionId(id);

        return condicionComercialRepository.save(condicion);
    }

    public void delete(Integer id) {
        condicionComercialRepository.deleteById(id);
    }
}