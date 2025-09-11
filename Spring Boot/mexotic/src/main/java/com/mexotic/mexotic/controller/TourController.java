package com.mexotic.mexotic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mexotic.mexotic.model.Categoria;
import com.mexotic.mexotic.model.Estado;
import com.mexotic.mexotic.model.Tour;
import com.mexotic.mexotic.service.TourService;

@RestController
@RequestMapping(path = "/mexotic/tours/") // http://localhost:8080/mexotic/tours/
public class TourController {

    private final TourService service;

    @Autowired
    public TourController(TourService service ) {
        this.service = service;
    }

    // GET
    @GetMapping
    public Page<Tour> getTours(@RequestParam(defaultValue = "0") int page, 
                               @RequestParam(defaultValue = "12") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return service.getTours(pageable);
    } // getTours

    @GetMapping(path = "{tourId}") // http://localhost:8080/mexotic/tours/1
    public Tour getTour(@PathVariable("tourId") Long idTour) {
        return service.getTour(idTour);
    } // getTour

    // DELETE
    @DeleteMapping(path = "{tourId}") // http://localhost:8080/mexotic/tours/1
    public Tour deleteTour(@PathVariable("tourId") Long idTour) {
        return service.deleteTour(idTour);
    } // deleteTour

    // POST
    @PostMapping
    public Tour addTour(@RequestBody Tour tour){
        return service.addTour(tour);
    } // addTour

    // PUT
    @PutMapping(path = "{tourId}")
    public Tour updateTour(@PathVariable("tourId") Long idTour,
        @RequestParam(required = false) String nombre,
        @RequestParam(required = false) Estado estado,
        @RequestParam(required = false) String ciudad,
        @RequestParam(required = false) String imgPortada,
        @RequestParam(required = false) String img,
        @RequestParam(required = false) String descripcion,
        @RequestParam(required = false) String duracion,
        @RequestParam(required = false) Double precio,
        @RequestParam(required = false) Double precioExclusivo,
        @RequestParam(required = false) String incluye,
        @RequestParam(required = false) Categoria categoria
    ) {
        return service.updateTour(idTour, nombre, estado, ciudad, imgPortada, img, descripcion, duracion, precio, precioExclusivo, incluye, categoria);
    } // updateProducto

} // class TourController

