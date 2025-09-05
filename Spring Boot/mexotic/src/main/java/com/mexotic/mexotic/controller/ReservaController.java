package com.mexotic.mexotic.controller;

import com.mexotic.mexotic.model.Reserva;
import com.mexotic.mexotic.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(origins = "*") // Permite CORS para pruebas desde frontend o Postman
public class ReservaController {

    private final ReservaService service;

    @Autowired
    public ReservaController(ReservaService service) {
        this.service = service;
    }

    // GET todas las reservas
    @GetMapping
    public List<Reserva> getAll() {
        return service.findAll();
    }

    // GET reserva por ID
    @GetMapping("/{id}")
    public Reserva getById(@PathVariable Long id) {
        return service.findByIdOrThrow(id);
    }

    // POST crear nueva reserva
    @PostMapping
    public ResponseEntity<Reserva> create(@RequestBody Reserva reserva) {
        Reserva created = service.create(reserva);
        return ResponseEntity.created(URI.create("/api/reservas/" + created.getIdReserva())).body(created);
    }

    // PUT actualizar reserva
    @PutMapping("/{id}")
    public Reserva update(@PathVariable Long id, @RequestBody Reserva reserva) {
        return service.update(id, reserva);
    }

    // DELETE eliminar reserva
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Extra: GET reservas por usuario
    @GetMapping("/usuario/{fkIdUsuario}")
    public List<Reserva> getByUsuario(@PathVariable Long fkIdUsuario) {
        return service.findByUsuario(fkIdUsuario);
    }
}
