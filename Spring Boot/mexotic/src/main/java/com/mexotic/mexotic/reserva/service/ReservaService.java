package com.mexotic.mexotic.reserva.service;

import com.mexotic.mexotic.reserva.model.Reserva;
import com.mexotic.mexotic.reserva.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> getReservaById(Integer id) {
        return reservaRepository.findById(id);
    }

    public Reserva createReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva updateReserva(Integer id, Reserva reservaDetails) {
        return reservaRepository.findById(id)
                .map(reserva -> {
                    reserva.setCantidad(reservaDetails.getCantidad());
                    reserva.setPago(reservaDetails.getPago());
                    reserva.setUsuario(reservaDetails.getUsuario());
                    return reservaRepository.save(reserva);
                })
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    public void deleteReserva(Integer id) {
        reservaRepository.deleteById(id);
    }
}
