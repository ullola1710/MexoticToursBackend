package com.mexotic.mexotic.controller;

import com.mexotic.mexotic.dto.ReservaRequest;
import com.mexotic.mexotic.model.Reserva;
//import com.mexotic.mexotic.service.PagoService;
import com.mexotic.mexotic.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/mexotic/reservas/")
public class ReservaController {

	private final ReservaService reservaService;
  

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
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
    
    @GetMapping("/usuario/{fkIdUsuario}")
    public List<Reserva> getByUsuario(@PathVariable Long fkIdUsuario) {
        return reservaService.findByUsuario(fkIdUsuario);
    }
  

    // POST crear nueva reserva
    @PostMapping
    public ResponseEntity<Reserva> createReserva(@RequestBody ReservaRequest request) {
        Reserva createdReserva = reservaService.create(request.getReserva(), request.getTours(), request.getCantidades());
        return ResponseEntity.created(URI.create("/mexotic/reservas/" + createdReserva.getIdReserva()))
                .body(createdReserva);
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

}
