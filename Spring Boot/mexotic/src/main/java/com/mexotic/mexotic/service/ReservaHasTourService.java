package com.mexotic.mexotic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mexotic.mexotic.model.ReservaHasTour;
import com.mexotic.mexotic.repository.ReservaHasTourRepository;

@Service
public class ReservaHasTourService {
	private final ReservaHasTourRepository reservahastourRepository;

    public ReservaHasTourService(ReservaHasTourRepository reservahastourRepository) {
        this.reservahastourRepository = reservahastourRepository;
    }

    public List<ReservaHasTour> getAll() {
        return reservahastourRepository.findAll();
    }

    public Optional<ReservaHasTour> getById(Long id) {
        return reservahastourRepository.findById(id);
    }

    public ReservaHasTour saveReservaHasTour(ReservaHasTour reservaHasTour) {
        return reservahastourRepository.save(reservaHasTour);
    }

    public void deleteReservaHasTour(Long id) {
    	reservahastourRepository.deleteById(id);
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
