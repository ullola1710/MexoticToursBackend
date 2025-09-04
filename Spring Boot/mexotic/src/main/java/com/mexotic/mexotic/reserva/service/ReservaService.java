package com.mexotic.mexotic.reserva.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mexotic.mexotic.reserva.model.Reserva;
import com.mexotic.mexotic.usuario.model.Usuario;
import com.mexotic.mexotic.usuario.service.UsuarioService;

@Service
public class ReservaService {
    private final ArrayList<Reserva> lista = new ArrayList<Reserva>();
    
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    public ReservaService() {
        // Obtener algunos usuarios de ejemplo para las reservas
        List<Usuario> usuarios = usuarioService.getUsuario();
        
        // Añadir reservas de ejemplo con objetos Usuario reales
        if (usuarios.size() >= 5) {
            lista.add(new Reserva(2, usuarios.get(8)));  // Usuario Miguel
            lista.add(new Reserva(4, usuarios.get(9)));  // Usuario Ana
            lista.add(new Reserva(1, usuarios.get(10))); // Usuario Roberto
            lista.add(new Reserva(3, usuarios.get(11))); // Usuario Sofía
            lista.add(new Reserva(5, usuarios.get(12))); // Usuario Carlos
        }
    }

    public List<Reserva> getReservas() {
        return lista;
    }//getReservas

    public Reserva getReserva(Long idReserva) {
        Reserva tmpRes = null;
        for (Reserva res : lista) {
            if (res.getIdReserva().equals(idReserva)) {
                tmpRes = res;
                break;
            }//if
        }//foreach
        return tmpRes;
    }//getReserva

    public Reserva deleteReserva(Long idReserva) {
        Reserva tmpRes = null;
        for (Reserva res : lista) {
            if (res.getIdReserva().equals(idReserva)) {
                tmpRes = res;
                lista.remove(res);
                break;
            }//if
        }//foreach
        return tmpRes;
    }//deleteReserva

    public Reserva addReserva(Reserva reserva) {
        lista.add(reserva);
        return reserva;
    }//addReserva

    public Reserva updateReserva(Long idReserva, Integer cantidad, Usuario usuario) {
        Reserva tmpRes = null;
        for (Reserva res : lista) {
            if (res.getIdReserva().equals(idReserva)) {
                if (cantidad != null) res.setCantidad(cantidad);
                if (usuario != null) res.setUsuario(usuario);
                tmpRes = res;
                break;
            }//if
        }//foreach
        return tmpRes;
    }//updateReserva
    
    // Método adicional para buscar reservas por ID de usuario
    public List<Reserva> getReservasByUsuario(Long idUsuario) {
        List<Reserva> reservasUsuario = new ArrayList<>();
        for (Reserva res : lista) {
            if (res.getUsuario().getIdUsuario().equals(idUsuario)) {
                reservasUsuario.add(res);
            }//if
        }//foreach
        return reservasUsuario;
    }//getReservasByUsuario
}//class ReservaService

//package com.mexotic.mexotic.reserva.service;
//
//import com.mexotic.mexotic.reserva.model.Reserva;
//import com.mexotic.mexotic.reserva.repository.ReservaRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
////@Service
////public class ReservaService {
//
////    private final ReservaRepository reservaRepository;
//
////    public ReservaService(ReservaRepository reservaRepository) {
////        this.reservaRepository = reservaRepository;
////    }
//
//    public List<Reserva> getAllReservas() {
////        return reservaRepository.findAll();
//    }
//
//    public Optional<Reserva> getReservaById(Integer id) {
////        return reservaRepository.findById(id);
//    }
//
//    public Reserva createReserva(Reserva reserva) {
//        //return reservaRepository.save(reserva);
//    }
//
//    public Reserva updateReserva(Integer id, Reserva reservaDetails) {
//        return reservaRepository.findById(id)
//                .map(reserva -> {
//                    reserva.setCantidad(reservaDetails.getCantidad());
//                    reserva.setPago(reservaDetails.getPago());
//                    reserva.setUsuario(reservaDetails.getUsuario());
//                    return reservaRepository.save(reserva);
//                })
//                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
//    }
//
//    public void deleteReserva(Integer id) {
//       // reservaRepository.deleteById(id);
//    }
//}


