package com.tuempresa.gestionra.service;

import com.tuempresa.gestionra.model.Ra;
import com.tuempresa.gestionra.repository.RaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RaService {

    @Autowired
    private RaRepository raRepository;

    // 1. LEER TODOS
    public List<Ra> obtenerTodos() {
        return raRepository.findAll();
    }

    // 2. LEER UNO POR ID
    public Optional<Ra> obtenerPorId(Integer id) {
        return raRepository.findById(id);
    }

    // 3. CREAR / ACTUALIZAR
    public Ra guardar(Ra ra) {
        return raRepository.save(ra);
    }

    // 4. ELIMINAR
    public void eliminar(Integer id) {
        raRepository.deleteById(id);
    }
}