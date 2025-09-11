package com.mexotic.mexotic.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.mexotic.mexotic.model.Reserva;
import com.mexotic.mexotic.model.ReservaHasTour;
//import com.mexotic.mexotic.model.Tour;
import com.mexotic.mexotic.repository.ReservaHasTourRepository;
//import com.mexotic.mexotic.repository.ReservaRepository;
//import com.mexotic.mexotic.repository.TourRepository;

@Service
public class ReservaHasTourService {
	
	@Autowired
	private final ReservaHasTourRepository reservaHasTourRepository;
	
//	@Autowired
//	private TourRepository tourRepository;
//	@Autowired
//	private ReservaRepository reservaRepository;
	
	@Autowired
    public ReservaHasTourService(ReservaHasTourRepository reservaHasTourRepository) {
        this.reservaHasTourRepository = reservaHasTourRepository;
    }
    
//    public ReservaHasTour crearRelacion(Long reservaId, Long tourId, int cantidad) {
//        Reserva reserva = reservaRepository.findById(reservaId)
//                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
//        Tour tour = tourRepository.findById(tourId)
//                .orElseThrow(() -> new RuntimeException("Tour no encontrado"));
//
//        ReservaHasTour relacion = new ReservaHasTour();
//        relacion.setReserva(reserva);
//        relacion.setTour(tour);
//        relacion.setCantidad(cantidad);
//
//        return reservahastourRepository.save(relacion);
//    }//Relacion idReserva y idTour con la cantidad 

    @Transactional(readOnly = true)
    public List<ReservaHasTour> getAll() {
        return reservaHasTourRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Optional<ReservaHasTour> getById(Long id) {
        return reservaHasTourRepository.findById(id);
    }
    
//    @Transactional
//    public ReservaHasTour saveReservaHasTour(ReservaHasTour reservaHasTour) {
//        return reservahastourRepository.save(reservaHasTour);
//    }
    
    @Transactional
    public void deleteReservaHasTour(Long id) {
        reservaHasTourRepository.deleteById(id);
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
