package com.mexotic.mexotic.controller;

import java.util.List;

import com.mexotic.mexotic.model.UsuarioHasTour;
import com.mexotic.mexotic.service.UsuarioHasTourService;

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
@RequestMapping(path = "/mexotic/usuario-tours/") // http://localhost:8080/mexotic/usuario-tours/
public class UsuarioHasTourController {

    private final UsuarioHasTourService service;

    @Autowired
    public UsuarioHasTourController(UsuarioHasTourService service) {
        this.service = service;
    }

    // Obtener todos los registros
    @GetMapping
    public List<UsuarioHasTour> getAll() {
        return service.getAll();
    }

    // Obtener un registro por ID
    @GetMapping(path = "/{id}")
    public UsuarioHasTour getById(@PathVariable Long id) {
        return service.getById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
    }

    // Crear o actualizar un registro
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioHasTour createUsuarioHasTour(@RequestBody UsuarioHasTour usuarioHasTour) {
        return service.saveUsuarioHasTour(usuarioHasTour);
    }

    // Eliminar un registro por ID
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUsuarioHasTour(@PathVariable Long id) {
        service.deleteUsuarioHasTour(id);
    }
}




//package com.mexotic.mexotic.controller;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(path = "/mexotic/usuario-tours/") //http://localhost:8080/mexotic/usuario-tours/
//public class UsuarioHasToursController {
//    private final UsuarioHasToursService service;
//    
//    @Autowired
//    public UsuarioHasToursController(UsuarioHasToursService service) {
//        this.service = service;
//    }
//
//    @GetMapping
//    public List<UsuarioHasTours> getAll() {
//        return service.getAll();
//    }
//
//    @GetMapping(path= "/{id}")
//    public UsuarioHasTours getById(@PathVariable Long id) {
//        return service.getById(id)
//                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public UsuarioHasTours createUsuarioHasTour(@RequestBody UsuarioHasTours usuarioHasTours) {
//        return service.saveUsuarioHasTour(usuarioHasTours);
//    }
//
//    @DeleteMapping(path= "/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteUsuarioHasTour(@PathVariable Long id) {
//        service.deleteUsuarioHasTour(id);
//    }
//}
