package com.mexotic.mexotic.controller;

import com.mexotic.mexotic.model.Reserva;
import com.mexotic.mexotic.service.ReservaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/reservas/") //http://localhost:8080/api/reservas
@CrossOrigin(origins = "*")
public class ReservaController {

    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    // Obtener todas
    @GetMapping
    public List<Reserva> getAll() {
        return service.findAll();
    }

    // Obtener por id
    @GetMapping("/{id}")
    public Reserva getById(@PathVariable Long id) {
        return service.findByIdOrThrow(id);
    }

    // Crear nueva
    @PostMapping
    public ResponseEntity<Reserva> create(@RequestBody Reserva reserva) {
        Reserva created = service.create(reserva);
        return ResponseEntity
                .created(URI.create("/api/reservas/" + created.getIdReserva()))
                .body(created);
    }

    // Actualizar completa/parcial (PUT)
    @PutMapping("/{id}")
    public Reserva update(@PathVariable Long id, @RequestBody Reserva reserva) {
        return service.update(id, reserva);
    }

    // Borrar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Extra: listar reservas por usuario
    @GetMapping("/usuario/{fkIdUsuario}")
    public List<Reserva> getByUsuario(@PathVariable Long fkIdUsuario) {
        return service.findByUsuario(fkIdUsuario);
    }
}
