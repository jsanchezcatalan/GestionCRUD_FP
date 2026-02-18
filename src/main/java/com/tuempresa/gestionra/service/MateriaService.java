package com.tuempresa.gestionra.service;

import com.tuempresa.gestionra.model.Materia;
import com.tuempresa.gestionra.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Esta anotación es obligatoria para decirle a Spring que es un Servicio
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository; // Llamamos a tu Repositorio

    // 1. LEER TODAS (Equivale a tu antiguo listar())
    public List<Materia> obtenerTodas() {
        return materiaRepository.findAll();
    }

    // 2. LEER UNA SOLA POR ID (Equivale a tu antiguo obtener(int id))
    public Optional<Materia> obtenerPorId(Integer id) {
        return materiaRepository.findById(id);
    }

    // 3. CREAR / ACTUALIZAR (Equivale a tu antiguo guardar(Asignatura a))
    public Materia guardar(Materia materia) {
        return materiaRepository.save(materia); 
        // En JPA el .save() detecta automáticamente si es un INSERT o un UPDATE
    }

    // 4. ELIMINAR (Equivale a tu antiguo eliminar(int id))
    public void eliminar(Integer id) {
        materiaRepository.deleteById(id);
    }
}