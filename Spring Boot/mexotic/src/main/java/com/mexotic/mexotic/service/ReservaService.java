package com.mexotic.mexotic.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.mexotic.mexotic.model.Reserva;

@Service
public class ReservaService {
    private List<Reserva> reservas = new ArrayList<>();

    public List<Reserva> getAllReservas() {
        return new ArrayList<>(reservas); // Retorna una copia para evitar modificaciones externas
    }

    public Optional<Reserva> getReservaById(Long id) {
        return reservas.stream()
                .filter(reserva -> reserva.getId().equals(id))
                .findFirst();
    }

    public Reserva createReserva(Reserva reserva) {
        if (reserva.getId() == null) {
            Long newId = reservas.stream().mapToLong(Reserva::getId).max().orElse(0L) + 1;
            reserva.setId(newId);
        }
        reservas.add(reserva);
        return reserva;
    }

    public Optional<Reserva> updateReserva(Long id, Reserva updatedReserva) {
        Optional<Reserva> reservaOpt = getReservaById(id);
        if (reservaOpt.isPresent()) {
            Reserva reserva = reservaOpt.get();
            reserva.setFechaReserva(updatedReserva.getFechaReserva());
            reserva.setEstado(updatedReserva.getEstado());
            reserva.setUsuarioId(updatedReserva.getUsuarioId());
            return Optional.of(reserva);
        }
        return Optional.empty();
    }

    public boolean deleteReserva(Long id) {
        return reservas.removeIf(reserva -> reserva.getId().equals(id));
    }
}
