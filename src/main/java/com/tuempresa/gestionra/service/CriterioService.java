package com.tuempresa.gestionra.service;

import com.tuempresa.gestionra.model.Criterio;
import com.tuempresa.gestionra.repository.CriterioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriterioService {

    @Autowired
    private CriterioRepository criterioRepository;

    // 1. LEER TODOS
    public List<Criterio> obtenerTodos() {
        return criterioRepository.findAll();
    }

    // 2. LEER UNO POR ID
    public Optional<Criterio> obtenerPorId(Integer id) {
        return criterioRepository.findById(id);
    }

    // 3. CREAR / ACTUALIZAR
    public Criterio guardar(Criterio criterio) {
        return criterioRepository.save(criterio);
    }

    // 4. ELIMINAR
    public void eliminar(Integer id) {
        criterioRepository.deleteById(id);
    }
}