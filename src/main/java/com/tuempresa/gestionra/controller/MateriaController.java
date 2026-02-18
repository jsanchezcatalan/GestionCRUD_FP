package com.tuempresa.gestionra.controller;

import com.tuempresa.gestionra.model.Materia;
import com.tuempresa.gestionra.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Indica que es un controlador REST (devuelve JSON, no vistas JSP)
@RequestMapping("/api/materias") // La URL base para esta entidad
public class MateriaController {

    @Autowired
    private MateriaService materiaService; // Llamamos al servicio, respetando el MVC

    // GET: /api/materias (Listar todas)
    @GetMapping
    public List<Materia> listarTodas() {
        return materiaService.obtenerTodas();
    }

    // GET: /api/materias/1 (Obtener una por ID)
    @GetMapping("/{id}")
    public ResponseEntity<Materia> obtenerPorId(@PathVariable Integer id) {
        Optional<Materia> materia = materiaService.obtenerPorId(id);
        return materia.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST: /api/materias (Crear nueva)
    @PostMapping
    public Materia crear(@RequestBody Materia materia) {
        return materiaService.guardar(materia);
    }

// PUT: /api/materias/1 (Actualizar existente)
    @PutMapping("/{id}")
    public ResponseEntity<Materia> actualizar(@PathVariable Integer id, @RequestBody Materia materiaDetalles) {
        Optional<Materia> materiaExistente = materiaService.obtenerPorId(id);
        if (!materiaExistente.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        materiaDetalles.setId(id); // Aseguramos que se actualice el ID correcto
        return ResponseEntity.ok(materiaService.guardar(materiaDetalles));
    }

    // DELETE: /api/materias/1 (Borrar)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!materiaService.obtenerPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        materiaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}