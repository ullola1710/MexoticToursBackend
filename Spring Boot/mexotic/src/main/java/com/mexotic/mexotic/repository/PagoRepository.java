package com.mexotic.mexotic.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mexotic.mexotic.model.Pago;
import com.mexotic.mexotic.model.Reserva;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long>{
		Optional<Pago> findByReserva(Reserva reserva);
//		Optional<Pago> findByFechaPago(Date fechaPago);
//		Optional<Pago> findByMetodoPago(String metodoPago);
	
}
