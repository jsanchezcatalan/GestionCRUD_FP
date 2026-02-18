package com.tuempresa.gestionra.controller;

import com.tuempresa.gestionra.model.Criterio;
import com.tuempresa.gestionra.service.CriterioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/criterios")
public class CriterioController {

    @Autowired
    private CriterioService criterioService;

    @GetMapping
    public List<Criterio> listarTodos() {
        return criterioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Criterio> obtenerPorId(@PathVariable Integer id) {
        Optional<Criterio> criterio = criterioService.obtenerPorId(id);
        return criterio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Criterio crear(@RequestBody Criterio criterio) {
        return criterioService.guardar(criterio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Criterio> actualizar(@PathVariable Integer id, @RequestBody Criterio criterioDetalles) {
        if (!criterioService.obtenerPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        criterioDetalles.setId(id);
        return ResponseEntity.ok(criterioService.guardar(criterioDetalles));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!criterioService.obtenerPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        criterioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}