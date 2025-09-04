package com.mexotic.mexotic.controller;

import com.mexotictours.models.Usuario;
import com.mexotictours.models.Tour;
import com.mexotictours.models.UsuarioHasTour;
import com.mexotictours.models.UsuarioHasTourId;
import com.mexotictours.services.UsuarioHasTourService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/usuario-tours")
public class UsuarioHasTourController {
	private final UsuarioHasTourService service;

    public UsuarioHasTourController(UsuarioHasTourService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioHasTour> getAll() {
        return service.getAll();
    }

    @GetMapping("/{usuarioId}/{tourId}")
    public UsuarioHasTour getById(@PathVariable Long usuarioId, @PathVariable Long tourId) {
        return service.getById(new UsuarioHasTourId(usuarioId, tourId))
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
    }

    @PostMapping
    public UsuarioHasTour create(@RequestBody UsuarioHasTour usuarioHasTour) {
        return service.save(usuarioHasTour.getUsuario(), usuarioHasTour.getTour());
    }

    @DeleteMapping("/{usuarioId}/{tourId}")
    public void delete(@PathVariable Long usuarioId, @PathVariable Long tourId) {
        service.delete(new UsuarioHasTourId(usuarioId, tourId));
    }

}
