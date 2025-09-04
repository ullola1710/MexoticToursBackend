package com.mexotic.mexotic.reserva.controller;

import com.mexotic.mexotic.reserva.model.Reserva;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final List<Reserva> reservas = new ArrayList<>(); // Simula base de datos

    // GET:Obtener todas las reservas
    @GetMapping
    public ResponseEntity<List<Reserva>> getAllReservas() {
        return ResponseEntity.ok(reservas);
    }

    // GET:Obtener reserva por ID
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable Long id) {
        Optional<Reserva> reserva = reservas.stream().filter(r -> r.getId().equals(id)).findFirst();
        return reserva.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST:Crear reserva
    @PostMapping
    public ResponseEntity<Reserva> createReserva(@RequestBody Reserva reserva) {
        reserva.setId((long) (reservas.size() + 1)); // ID simulado
        reservas.add(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
    }

    // PUT:Actualizar reserva
    @PutMapping("/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable Long id, @RequestBody Reserva updatedReserva) {
        Optional<Reserva> reservaOpt = reservas.stream().filter(r -> r.getId().equals(id)).findFirst();
        if (reservaOpt.isPresent()) {
            Reserva reserva = reservaOpt.get();
            reserva.setFechaReserva(updatedReserva.getFechaReserva());
            reserva.setEstado(updatedReserva.getEstado());
            reserva.setUsuarioId(updatedReserva.getUsuarioId());
            return ResponseEntity.ok(reserva);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE: Eliminar reserva
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Long id) {
        boolean removed = reservas.removeIf(r -> r.getId().equals(id));
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
