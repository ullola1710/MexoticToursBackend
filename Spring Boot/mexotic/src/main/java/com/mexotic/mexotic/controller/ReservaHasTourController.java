package com.mexotic.mexotic.controller;

import java.util.List;

import com.mexotic.mexotic.model.ReservaHasTour;
//import com.mexotic.mexotic.model.UsuarioHasTour;
import com.mexotic.mexotic.service.ReservaHasTourService;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mexotic/reserva-tours")
public class ReservaHasTourController {
    @Autowired
    private ReservaHasTourService reservaHasTourService;

    @PostMapping("/{reservaId}/{tourId}")
    public ReservaHasTour crearRelacion(
            @PathVariable Long reservaId,
            @PathVariable Long tourId,
            @RequestParam int cantidad) {
        return reservaHasTourService.crearRelacion(reservaId, tourId, cantidad);
    }

    
    @Autowired
    public ReservaHasTourController(ReservaHasTourService reservaHasTourService) {
        this.reservaHasTourService = reservaHasTourService;
    }

    @GetMapping
    public List<ReservaHasTour> getAll() {
        return reservaHasTourService.getAll();
    }

    @GetMapping(path= "/{id}")
    public ReservaHasTour getById(@PathVariable Long id) {
        return reservaHasTourService.getById(id)
                .orElseThrow(() -> new RuntimeException("Relación no encontrada"));
    }

    @PostMapping
    public ReservaHasTour create(@RequestBody ReservaHasTour reservaHasTours) {
        return reservaHasTourService.saveReservaHasTour(reservaHasTours);
    }
    
    @PutMapping(path="/{id}")
    public ReservaHasTour update(@PathVariable Long id, @RequestBody ReservaHasTour reservaHasTours) {
    	ReservaHasTour existente = reservaHasTourService.getById(id)
                .orElseThrow(() -> new RuntimeException("Relación no encontrada"));

        existente.setReserva(reservaHasTours.getReserva());
        existente.setTour(reservaHasTours.getTour());

        return reservaHasTourService.saveReservaHasTour(existente);
    }

    @DeleteMapping(path= "/{id}")
    public void deleteReservaHasTour(@PathVariable Long id) {
    	reservaHasTourService.deleteReservaHasTour(id);
    }
}



//package com.mexotic.mexotic.reservahastours.controller;
//
//import java.util.List;
//
//import com.mexotic.mexotic.reservahastours.model.ReservaHasTours;
//import com.mexotic.mexotic.reservahastours.service.ReservaHasToursService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping(path = "/mexotic/reserva-tours/") //http://localhost:8080/mexotic/reserva-tours/
//public class ReservaHasToursController {
//	private final ReservaHasToursService service;
//	@Autowired
//    public ReservaHasToursController(ReservaHasToursService service) {
//        this.service = service;
//    }
//
//    @GetMapping
//    public List<ReservaHasTours> getAll() {
//        return service.getAll();
//    }
//
//    @GetMapping(path= "/{id}")
//    public ReservaHasTours getById(@PathVariable Long id) {
//        return service.getById(id)
//                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
//    }
//
//
//    @DeleteMapping(path= "/{id}")
//    public ReservaHasTours deleteReservaHasTour(@PathVariable ("id") Long id) {
//        return service.deleteReservaHasTour(id);
//    }
//}
