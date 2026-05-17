package com.tuapp.aerolineaapi.controller;

import com.tuapp.aerolineaapi.model.Pasajero;
import com.tuapp.aerolineaapi.service.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Pasajero> listarPasajeros() {
        return pasajeroService.findAll();
    }
}