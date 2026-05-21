package com.tuapp.aerolineaapi.service;

import com.tuapp.aerolineaapi.dto.ReservaRequestDTO;
import com.tuapp.aerolineaapi.dto.ReservaResponseDTO;
import com.tuapp.aerolineaapi.model.Pasajero;
import com.tuapp.aerolineaapi.model.Reserva;
import com.tuapp.aerolineaapi.model.Vuelo;
import com.tuapp.aerolineaapi.repository.PasajeroRepository;
import com.tuapp.aerolineaapi.repository.ReservaRepository;
import com.tuapp.aerolineaapi.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final PasajeroRepository pasajeroRepository;
    private final VueloRepository vueloRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository,
                          PasajeroRepository pasajeroRepository,
                          VueloRepository vueloRepository) {
        this.reservaRepository = reservaRepository;
        this.pasajeroRepository = pasajeroRepository;
        this.vueloRepository = vueloRepository;
    }

    public List<ReservaResponseDTO> findAll() {
        return reservaRepository.findAll()
                .stream()
                .map(ReservaResponseDTO::desde)
                .collect(Collectors.toList());
    }

    public ReservaResponseDTO findById(Long id) {
        Reserva reserva = reservaRepository.findById(id).orElse(null);
        if (reserva == null) return null;
        return ReservaResponseDTO.desde(reserva);
    }

    public ReservaResponseDTO save(ReservaRequestDTO dto) {
        Pasajero pasajero = pasajeroRepository.findById(dto.getPasajeroId()).orElse(null);
        Vuelo vuelo = vueloRepository.findById(dto.getVueloId()).orElse(null);
        Reserva reserva = new Reserva(dto.getFechaReserva(), dto.getClase(), pasajero, vuelo);
        return ReservaResponseDTO.desde(reservaRepository.save(reserva));
    }

    public ReservaResponseDTO update(Long id, ReservaRequestDTO dto) {
        Reserva existente = reservaRepository.findById(id).orElse(null);
        if (existente == null) return null;
        Pasajero pasajero = pasajeroRepository.findById(dto.getPasajeroId()).orElse(null);
        Vuelo vuelo = vueloRepository.findById(dto.getVueloId()).orElse(null);
        existente.setFechaReserva(dto.getFechaReserva());
        existente.setClase(dto.getClase());
        existente.setPasajero(pasajero);
        existente.setVuelo(vuelo);
        return ReservaResponseDTO.desde(reservaRepository.save(existente));
    }

    public void delete(Long id) {
        reservaRepository.deleteById(id);
    }
}