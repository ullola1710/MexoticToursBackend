package com.mexotic.mexotic.controller;

import com.mexotic.mexotic.model.Reserva;
import com.mexotic.mexotic.service.ReservaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/mexotic/reservas/") // http:localhost:8080/mexotic/reservas/

public class ReservaController {

    private final ReservaService service;

    @Autowired
    public ReservaController(ReservaService service) {
        this.service = service;
    }

    // GET - Obtener todas las reservas
    @GetMapping
    public List<Reserva> getReservas() {
        return service.getReservas();
    }

    // GET - Obtener una reserva por ID
    @GetMapping(path = "{reservaId}") // http:localhost:8080/mexotic/reservas/1
    public Reserva getReserva(@PathVariable("reservaId") Long idReserva) {
        return service.getReserva(idReserva);
    }

    // DELETE - Eliminar una reserva por ID
    @DeleteMapping(path = "{reservaId}") // http:localhost:8080/mexotic/reservas/1
    public Reserva deleteReserva(@PathVariable("reservaId") Long idReserva) {
        return service.deleteReserva(idReserva);
    }

    // POST - Crear una nueva reserva
    @PostMapping
    public Reserva addReserva(@RequestBody Reserva reserva) {
        return service.addReserva(reserva);
    }

    // PUT - Actualizar una reserva existente
    @PutMapping(path = "{reservaId}") // http:localhost:8080/mexotic/reservas/1
    public Reserva updateReserva(@PathVariable("reservaId") Long idReserva,
                                 @RequestParam(required = false) Integer cantidad,
                                 @RequestParam(required = false) Long usuarioId) {
        // Para simplificar, aquí asumimos que pasas el ID del usuario
        // En una implementación real, podrías necesitar obtener el objeto Usuario completo
        // usando un servicio de usuario
        return service.updateReserva(idReserva, cantidad, null); // usuario se manejaría de forma diferente
    }

    // GET adicional - Obtener reservas por ID de usuario
    @GetMapping(path = "usuario/{usuarioId}") // http:localhost:8080/mexotic/reservas/usuario/1
    public List<Reserva> getReservasByUsuario(@PathVariable("usuarioId") Long idUsuario) {
        return service.getReservasByUsuario(idUsuario);
    }
}

//package com.mexotic.mexotic.reserva.controller;
//
//import com.mexotic.mexotic.reserva.model.Reserva;
//import com.mexotic.mexotic.reserva.service.ReservaService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/mexotic/reservas")
//public class ReservaController {
//
//    private final ReservaService reservaService;
//
//    public ReservaController(ReservaService reservaService) {
//        this.reservaService = reservaService;
//    }
//
//    @GetMapping
//    public List<Reserva> getAllReservas() {
//        return reservaService.getAllReservas();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Reserva> getReservaById(@PathVariable Integer id) {
//        return reservaService.getReservaById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public Reserva createReserva(@RequestBody Reserva reserva) {
//        return reservaService.createReserva(reserva);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Reserva> updateReserva(@PathVariable Integer id, @RequestBody Reserva reservaDetails) {
//        try {
//            return ResponseEntity.ok(reservaService.updateReserva(id, reservaDetails));
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteReserva(@PathVariable Integer id) {
//        reservaService.deleteReserva(id);
//        return ResponseEntity.noContent().build();
//    }
//}
