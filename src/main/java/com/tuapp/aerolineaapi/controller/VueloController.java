package com.tuapp.aerolineaapi.controller;

import com.tuapp.aerolineaapi.model.Vuelo;
import com.tuapp.aerolineaapi.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

    private final VueloService vueloService;

    @Autowired
    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping
    public List<Vuelo> listarVuelos() {
        return vueloService.findAll();
    }
}