//package com.mexotic.mexotic.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.stereotype.Service;
//import com.mexotic.mexotic.model.UsuarioHasTour;
//import com.mexotic.mexotic.repository.UsuarioHasTourRepository;
//
//@Service
//public class UsuarioHasTourService {
//    private final UsuarioHasTourRepository usuarioshastourRepository;
//
//    public UsuarioHasTourService(UsuarioHasTourRepository usuarioshastourRepository) {
//        this.usuarioshastourRepository = usuarioshastourRepository;
//    }
//
//    // Obtener todos los registros
//    public List<UsuarioHasTour> getAll() {
//        return usuarioshastourRepository.findAll();
//    }
//
//    public Optional<UsuarioHasTour> getById(Long id) {
//        return usuarioshastourRepository.findById(id);
//    }
//
//    public UsuarioHasTour saveUsuarioHasTour(UsuarioHasTour usuarioHasTour) {
//        return usuarioshastourRepository.save(usuarioHasTour);
//    }
//
//    public void deleteUsuarioHasTour(Long id) {
//    	usuarioshastourRepository.deleteById(id);
//    }
//}

//package com.mexotic.mexotic.service;
//
//import com.mexotic.mexotic.model.Usuario;
//import com.mexotic.mexotic.model.Tour;
//import com.mexotic.mexotic.model.UsuarioHasTour;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import com.mexotic.mexotic.repository.UsuarioHasTourRepository;
//
//@Service
//public class UsuarioHasTourService {
//	private final UsuarioHasTourRepository usuarioshastourRepository;
//	
//	public UsuarioHasTourService (UsuarioHasTourRepository usuarioshastourRepository) {
//		this.usuarioshastourRepository = usuarioshastourRepository;
//	}
//    public List<UsuarioHasTour> getAll() {
//        return usuarioshastourRepository.findAll();
//    }
//
//    public Optional<UsuarioHasTour> getById(Long id) {
//    	return usuarioshastourRepository.findById(id);
////        return registros.stream()
////                .filter(r -> r.getId().getUsuarioId().equals(id.getUsuarioId()) &&
////                             r.getId().getTourId().equals(id.getTourId()))
////                .findFirst();
//    }
//    
//    public UsuarioHasTour save(UsuarioHasTour usuarioHasTour) {
//        return usuarioshastourRepository.save(usuarioHasTour);
//    }
//    
//    public void delete(Long id) {
//        usuarioshastourRepository.deleteById(id);
//    }
////    public UsuarioHasTour save(Usuario usuario, Tour tour) {
////        UsuarioHasTour registro = new UsuarioHasTour(usuario, tour);
////        return usuarioshastourRepository.save(registro);
////    }
////    public UsuarioHasTour save(Usuario usuario, Tour tour) {
////        UsuarioHasTour registro = new UsuarioHasTour(usuario, tour);
////        registros.add(registro);
////        return registro;
////    }
//
////    public void delete(UsuarioHasTourId id) {
////        registros.removeIf(r -> r.getId().getUsuarioId().equals(id.getUsuarioId()) &&
////                                r.getId().getTourId().equals(id.getTourId()));
////    }
//    
//}

