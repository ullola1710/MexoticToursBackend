package com.mexotic.mexotic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mexotic.mexotic.model.ReservaHasTours;

@Service
public class ReservaHasToursService {
    private final ArrayList<ReservaHasTours> lista = new ArrayList<ReservaHasTours>();
    private Long nextId = 1L;
    
    public List<ReservaHasTours> getAll() {
        return lista;
    }
    
    public Optional<ReservaHasTours> getById(Long id) {
        return lista.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
    }

    public ReservaHasTours saveReservaHasTour(ReservaHasTours reservaHasTours) {
        // Asignar ID automáticamente si no tiene uno
        if (reservaHasTours.getId() == null) {
            reservaHasTours.setId(nextId++);
        } else {
            // Si ya tiene ID, eliminar el existente y agregar el nuevo (actualizar)
            deleteReservaHasTour(reservaHasTours.getId());
        }
        lista.add(reservaHasTours);
        return reservaHasTours;
    }

    public void deleteReservaHasTour(Long id) {
        lista.removeIf(r -> r.getId().equals(id));
    }
}

//package com.mexotic.mexotic.reservahastours.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import com.mexotic.mexotic.reservahastours.model.ReservaHasTours;
//
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class ReservaHasToursService {
//	private final ArrayList<ReservaHasTours> lista = new ArrayList<ReservaHasTours>();
//	
//	
//	public List<ReservaHasTours> getAll() {
//        return lista;
//    }
//	
//	 public Optional<ReservaHasTours> getById(Long id) {
//	        return lista.stream()
//	                .filter(r -> r.getId().equals(id))
//	                .findFirst();
//	    }
//
//	    public ReservaHasTours saveReservaHasTour(ReservaHasTours reservaHasTours) {
//	    	lista.add(reservaHasTours);
//	        return reservaHasTours;
//	    }
//
//	    public ReservaHasTours deleteReservaHasTour(Long id) {
//	    	lista.removeIf(r -> r.getId().equals(id));
//			return null;
//	    }
//	
//    
//}
