package com.mexotic.mexotic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mexotic.mexotic.model.UsuarioHasTour;

@Service
public class UsuarioHasTourService {

    private final ArrayList<UsuarioHasTour> lista = new ArrayList<>();
    private Long nextId = 1L;

    // Obtener todos los registros
    public List<UsuarioHasTour> getAll() {
        return lista;
    }

    // Obtener un registro por ID
    public Optional<UsuarioHasTour> getById(Long id) {
        return lista.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
    }

    // Guardar o actualizar un registro
    public UsuarioHasTour saveUsuarioHasTour(UsuarioHasTour usuarioHasTour) {
        // Asignar ID automáticamente si no tiene uno
        if (usuarioHasTour.getId() == null) {
            usuarioHasTour.setId(nextId++);
        } else {
            // Si ya tiene ID, eliminar el existente y agregar el nuevo (actualizar)
            deleteUsuarioHasTour(usuarioHasTour.getId());
        }
        lista.add(usuarioHasTour);
        return usuarioHasTour;
    }

    // Eliminar un registro por ID
    public void deleteUsuarioHasTour(Long id) {
        lista.removeIf(u -> u.getId().equals(id));
    }
}

//package com.mexotic.mexotic.service;
//
//import java.util.ArrayList;
//
//
//@Service
//public class UsuarioHasTourService {
//	private final ArrayList<UsuarioHasTour> registros = new ArrayList<UsuarioHasTour>();
//	
//    public List<UsuarioHasTour> getAll() {
//        return registros;
//    }
//
//    public Optional<UsuarioHasTour> getById(UsuarioHasTourId id) {
//        return registros.stream()
//                .filter(r -> r.getId().getUsuarioId().equals(id.getUsuarioId()) &&
//                             r.getId().getTourId().equals(id.getTourId()))
//                .findFirst();
//    }
//
//    public UsuarioHasTour save(Usuario usuario, Tour tour) {
//        UsuarioHasTour registro = new UsuarioHasTour(usuario, tour);
//        registros.add(registro);
//        return registro;
//    }
//
//    public void delete(UsuarioHasTourId id) {
//        registros.removeIf(r -> r.getId().getUsuarioId().equals(id.getUsuarioId()) &&
//                                r.getId().getTourId().equals(id.getTourId()));
//    }
<<<<<<< HEAD
//}
=======
//}
>>>>>>> 768aecf2e503da3177df726e72b2e7225c82144f
