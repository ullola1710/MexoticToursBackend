package com.mexotic.mexotic.repository;

import com.mexotic.mexotic.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    //Para listar por usuario
    List<Reserva> findByFkIdUsuario(Long fkIdUsuario);
}
