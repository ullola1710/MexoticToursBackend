package com.mexotic.mexotic.service;

import com.mexotic.mexotic.model.Reserva;
import com.mexotic.mexotic.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> getReservaById(Long id) {
        return reservaRepository.findById(id);
    }

    public Reserva createReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva updateReserva(Long id, Reserva reservaDetails) {
        return reservaRepository.findById(id).map(reserva -> {
            reserva.setNombreCliente(reservaDetails.getNombreCliente());
            reserva.setEmail(reservaDetails.getEmail());
            reserva.setTelefono(reservaDetails.getTelefono());
            reserva.setFechaReserva(reservaDetails.getFechaReserva());
            return reservaRepository.save(reserva);
        }).orElseThrow(() -> new RuntimeException("Reserva no encontrada con id " + id));
    }

    public void deleteReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}
