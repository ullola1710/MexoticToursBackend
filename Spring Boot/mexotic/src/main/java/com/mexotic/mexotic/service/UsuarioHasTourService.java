package com.mexotic.mexotic.service;

import com.mexotictours.models.Usuario;
import com.mexotictours.models.Tour;
import com.mexotictours.models.UsuarioHasTour;
import com.mexotictours.models.UsuarioHasTourId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioHasTourService {
	private final List<UsuarioHasTour> registros = new ArrayList<>();

    public List<UsuarioHasTour> getAll() {
        return registros;
    }

    public Optional<UsuarioHasTour> getById(UsuarioHasTourId id) {
        return registros.stream()
                .filter(r -> r.getId().getUsuarioId().equals(id.getUsuarioId()) &&
                             r.getId().getTourId().equals(id.getTourId()))
                .findFirst();
    }

    public UsuarioHasTour save(Usuario usuario, Tour tour) {
        UsuarioHasTour registro = new UsuarioHasTour(usuario, tour);
        registros.add(registro);
        return registro;
    }

    public void delete(UsuarioHasTourId id) {
        registros.removeIf(r -> r.getId().getUsuarioId().equals(id.getUsuarioId()) &&
                                r.getId().getTourId().equals(id.getTourId()));
    }
}
