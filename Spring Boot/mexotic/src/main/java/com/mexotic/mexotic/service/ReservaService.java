package com.mexotic.mexotic.service;

import com.mexotic.mexotic.model.Reserva;
import com.mexotic.mexotic.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
<<<<<<< HEAD

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
=======
    private final ArrayList<Reserva> lista = new ArrayList<Reserva>();
    private final UsuarioService usuarioService;
    
    @Autowired
    public ReservaService(UsuarioService usuarioService) {
    	this.usuarioService = usuarioService;
        // Obtener algunos usuarios de ejemplo para las reservas
        List<Usuario> usuarios = usuarioService.getUsuario();
        
        // Añadir reservas de ejemplo con objetos Usuario reales
        if (usuarios.size() >= 13) {
            lista.add(new Reserva(2, usuarios.get(8)));  // Usuario Miguel
            lista.add(new Reserva(4, usuarios.get(9)));  // Usuario Ana
            lista.add(new Reserva(1, usuarios.get(10))); // Usuario Roberto
            lista.add(new Reserva(3, usuarios.get(11))); // Usuario Sofía
            lista.add(new Reserva(5, usuarios.get(12))); // Usuario Carlos
        }
>>>>>>> 768aecf2e503da3177df726e72b2e7225c82144f
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
