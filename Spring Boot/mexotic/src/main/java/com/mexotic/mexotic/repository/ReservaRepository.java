package com.mexotic.mexotic.repository;

import com.mexotic.mexotic.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Método extra para filtrar por usuario (opcional)
    List<Reserva> findByFkIdUsuario(Long fkIdUsuario);
}