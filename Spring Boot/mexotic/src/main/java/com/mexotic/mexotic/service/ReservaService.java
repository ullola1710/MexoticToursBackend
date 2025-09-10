package com.mexotic.mexotic.service;

import com.mexotic.mexotic.model.Reserva;
import com.mexotic.mexotic.model.Usuario;
import com.mexotic.mexotic.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public Reserva findByIdOrThrow(Long idReserva) {
        return reservaRepository.findById(idReserva)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrada"));
    }

    public List<Reserva> findByUsuario(Long idUsuario) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        return reservaRepository.findByFkIdUsuario(usuario);
    }

    public Reserva create(Reserva reserva) {
        return reservaRepository.save(reserva);
    }


    public Reserva update(Long idReserva, Reserva input) {
        Reserva reserva = findByIdOrThrow(idReserva);
        if (input.getCantidad() != null) reserva.setCantidad(input.getCantidad());
        if (input.getFkIdUsuario() != null) reserva.setFkIdUsuario(input.getFkIdUsuario());
        return reservaRepository.save(reserva);
    }

    public void delete(Long idReserva) {
        if (!reservaRepository.existsById(idReserva)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrada");
        }
        reservaRepository.deleteById(idReserva);
    }
}
