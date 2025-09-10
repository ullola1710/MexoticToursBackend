package com.mexotic.mexotic.controller;

import com.mexotic.mexotic.model.Reserva;
import com.mexotic.mexotic.model.Usuario;
import com.mexotic.mexotic.service.PagoService;
import com.mexotic.mexotic.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/mexotic/reservas/")
@CrossOrigin(origins = "*") // Permite CORS para pruebas desde frontend o Postman
public class ReservaController {

	private final ReservaService reservaService;
    private final PagoService pagoService;

    @Autowired
    public ReservaController(ReservaService reservaService, PagoService pagoService) {
        this.reservaService = reservaService;
        this.pagoService = pagoService;
    }

    // GET todas las reservas
    @GetMapping
    public List<Reserva> getAll() {
        return reservaService.findAll();
    }

//     GET reserva por ID
    @GetMapping("/{id}")
    public Reserva getById(@PathVariable Long idReserva) {
        return reservaService.findByIdOrThrow(idReserva);
    }
  


    // POST crear nueva reserva
    @PostMapping
    public ResponseEntity<Reserva> create(@RequestBody Reserva reserva) {
        Reserva created = reservaService.create(reserva);
        return ResponseEntity.created(URI.create("/api/reservas/" + created.getIdReserva())).body(created);
    }

    // PUT actualizar reserva
    @PutMapping("/{id}")
    public Reserva update(@PathVariable Long idReserva, @RequestBody Reserva reserva) {
        return reservaService.update(idReserva, reserva);
    }

    // DELETE eliminar reserva
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long idReserva) {
    	reservaService.delete(idReserva);
        return ResponseEntity.noContent().build();
    }

    // Extra: GET reservas por usuario
    @GetMapping("/usuario/{fkIdUsuario}")
    public List<Reserva> getByUsuario(@PathVariable Long fkIdUsuario) {
        return reservaService.findByUsuario(fkIdUsuario);
    }
}
