package com.mexotic.mexotic.reservahastours.controller;

import java.util.List;

import com.mexotic.mexotic.reservahastours.model.ReservaHasTours;
import com.mexotic.mexotic.reservahastours.service.ReservaHasToursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/mexotic/reserva-tours/") //http://localhost:8080/mexotic/reserva-tours/
public class ReservaHasToursController {
    private final ReservaHasToursService service;
    
    @Autowired
    public ReservaHasToursController(ReservaHasToursService service) {
        this.service = service;
    }

    @GetMapping
    public List<ReservaHasTours> getAll() {
        return service.getAll();
    }

    @GetMapping(path= "/{id}")
    public ReservaHasTours getById(@PathVariable Long id) {
        return service.getById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReservaHasTours createReservaHasTour(@RequestBody ReservaHasTours reservaHasTours) {
        return service.saveReservaHasTour(reservaHasTours);
    }

    @DeleteMapping(path= "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReservaHasTour(@PathVariable Long id) {
        service.deleteReservaHasTour(id);
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
