package com.mexotic.mexotic.controller;

import com.mexotic.mexotic.model.Reserva;
import com.mexotic.mexotic.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mexotic/reservas") // http://localhost:8080/mexotic/reservas/
@CrossOrigin(origins = "http://localhost:8080")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaService.getAllReservas();
    }

    @GetMapping("/{id}")
    public Reserva getReservaById(@PathVariable Long id) {
        return reservaService.getReservaById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada con id " + id));
    }

    @PostMapping
    public Reserva createReserva(@RequestBody Reserva reserva) {
        return reservaService.createReserva(reserva);
    }

    @PutMapping("/{id}")
    public Reserva updateReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        return reservaService.updateReserva(id, reserva);
    }

    @DeleteMapping("/{id}")
    public void deleteReserva(@PathVariable Long id) {
        reservaService.deleteReserva(id);
    }
}
