package com.mexotic.mexotic.service;

import com.mexotic.mexotic.model.Reserva;
import com.mexotic.mexotic.repository.ReservaRepository;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public Reserva findByIdOrThrow(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrada"));
    }

    public List<Reserva> findByUsuario(Long fkIdUsuario) {
        return reservaRepository.findByFkIdUsuario(fkIdUsuario);
    }

    public Reserva create(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva update(Long id, Reserva input) {
        Reserva r = findByIdOrThrow(id);
        if (input.getCantidad() != null) r.setCantidad(input.getCantidad());
        if (input.getFkIdUsuario() != null) r.setFkIdUsuario(input.getFkIdUsuario());
        return reservaRepository.save(r);
    }

    public void delete(Long id) {
        if (!reservaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrada");
        }
        reservaRepository.deleteById(id);
    }
}
