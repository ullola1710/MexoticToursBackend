package com.mexotic.mexotic.reserva.service;

import com.mexotic.mexotic.reserva.model.Reserva;
import com.mexotic.mexotic.reserva.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    // Obtener todas las reservas
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    // Obtener reserva por ID
    public Optional<Reserva> getReservaById(Long id) {
        return reservaRepository.findById(id);
    }

    // Crear una nueva reserva
    public Reserva createReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // Actualizar una reserva existente
    public Optional<Reserva> updateReserva(Long id, Reserva updatedReserva) {
        Optional<Reserva> reservaOpt = reservaRepository.findById(id);
        if (reservaOpt.isPresent()) {
            Reserva reserva = reservaOpt.get();
            reserva.setFechaReserva(updatedReserva.getFechaReserva());
            reserva.setEstado(updatedReserva.getEstado());
            reserva.setUsuarioId(updatedReserva.getUsuarioId());
            return Optional.of(reservaRepository.save(reserva));
        }
        return Optional.empty();
    }

    // Eliminar una reserva
    public boolean deleteReserva(Long id) {
        if (reservaRepository.existsById(id)) {
            reservaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
