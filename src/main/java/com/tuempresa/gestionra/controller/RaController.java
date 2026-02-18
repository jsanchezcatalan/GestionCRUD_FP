package com.tuempresa.gestionra.controller;

import com.tuempresa.gestionra.model.Ra;
import com.tuempresa.gestionra.service.RaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ras")
public class RaController {

    @Autowired
    private RaService raService;

    @GetMapping
    public List<Ra> listarTodos() {
        return raService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ra> obtenerPorId(@PathVariable Integer id) {
        Optional<Ra> ra = raService.obtenerPorId(id);
        return ra.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ra crear(@RequestBody Ra ra) {
        return raService.guardar(ra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ra> actualizar(@PathVariable Integer id, @RequestBody Ra raDetalles) {
        if (!raService.obtenerPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        raDetalles.setId(id);
        return ResponseEntity.ok(raService.guardar(raDetalles));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!raService.obtenerPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        raService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}