package com.tuapp.aerolineaapi.controller;

import com.tuapp.aerolineaapi.model.Pasajero;
import com.tuapp.aerolineaapi.service.PasajeroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pasajeros")
public class PasajeroController {

    private final PasajeroService pasajeroService;

    @Autowired
    public PasajeroController(PasajeroService pasajeroService) {
        this.pasajeroService = pasajeroService;
    }

    @GetMapping
    public ResponseEntity<List<Pasajero>> obtenerTodos() {
        return ResponseEntity.ok(pasajeroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pasajero> obtenerPorId(@PathVariable Long id) {
        Pasajero pasajero = pasajeroService.findById(id);
        if (pasajero == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pasajero);
    }

    @PostMapping
    public ResponseEntity<Pasajero> crear(@Valid @RequestBody Pasajero pasajero) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pasajeroService.save(pasajero));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pasajero> actualizar(@PathVariable Long id, @Valid @RequestBody Pasajero datos) {
        Pasajero resultado = pasajeroService.update(id, datos);
        if (resultado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pasajeroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}