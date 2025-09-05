package com.mexotic.mexotic.controller;

import com.mexotic.mexotic.model.Usuario;
import com.mexotic.mexotic.model.Tour;
import com.mexotic.mexotic.model.UsuarioHasTour;
import com.mexotic.mexotic.service.UsuarioHasTourService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(path = "/usuario-tours")
public class UsuarioHasTourController {
	private final UsuarioHasTourService service;
	
	@Autowired
    public UsuarioHasTourController(UsuarioHasTourService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioHasTour> getAll() {
        return service.getAll();
    }
    

    @GetMapping(path="/{id}")
    public UsuarioHasTour getById(@PathVariable Long id) {
        return service.getById(id)
                .orElseThrow(() -> new RuntimeException("Relación no encontrada"));
    }

    @PostMapping
    public UsuarioHasTour create(@RequestBody UsuarioHasTour usuarioHasTour) {
        return service.saveUsuarioHasTour(usuarioHasTour);
    }

    @PutMapping(path="/{id}")
    public UsuarioHasTour update(@PathVariable Long id, @RequestBody UsuarioHasTour usuarioHasTour) {
        UsuarioHasTour existente = service.getById(id)
                .orElseThrow(() -> new RuntimeException("Relación no encontrada"));

        existente.setUsuario(usuarioHasTour.getUsuario());
        existente.setTour(usuarioHasTour.getTour());

        return service.saveUsuarioHasTour(existente);
    }

    @DeleteMapping(path="/{id}")
    public void deleteUsuarioHasTour(@PathVariable Long id) {
        service.deleteUsuarioHasTour(id);
    }

//    @GetMapping(path ="/{usuarioId}/{tourId}")
//    public UsuarioHasTour getById(@PathVariable Long usuarioId, @PathVariable Long tourId) {
//        return service.getById(new UsuarioHasTourId(usuarioId, tourId))
//                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
//    }
//
//    @PostMapping
//    public UsuarioHasTour create(@RequestBody UsuarioHasTour usuarioHasTour) {
//        return service.save(usuarioHasTour.getUsuario(), usuarioHasTour.getTour());
//    }
//
//    @DeleteMapping("/{usuarioId}/{tourId}")
//    public void delete(@PathVariable Long usuarioId, @PathVariable Long tourId) {
//        service.delete(new UsuarioHasTourId(usuarioId, tourId));
//    }

}
