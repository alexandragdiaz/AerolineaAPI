package com.tuapp.aerolineaapi.controller;

import com.tuapp.aerolineaapi.dto.ReservaRequestDTO;
import com.tuapp.aerolineaapi.dto.ReservaResponseDTO;
import com.tuapp.aerolineaapi.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public ResponseEntity<List<ReservaResponseDTO>> obtenerTodos() {
        return ResponseEntity.ok(reservaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> obtenerPorId(@PathVariable Long id) {
        ReservaResponseDTO resultado = reservaService.findById(id);
        if (resultado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(resultado);
    }

    @PostMapping
    public ResponseEntity<ReservaResponseDTO> crear(@Valid @RequestBody ReservaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody ReservaRequestDTO dto) {
        ReservaResponseDTO resultado = reservaService.update(id, dto);
        if (resultado == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        reservaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}