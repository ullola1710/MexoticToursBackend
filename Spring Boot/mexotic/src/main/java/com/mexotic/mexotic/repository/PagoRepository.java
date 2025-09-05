package com.mexotic.mexotic.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mexotic.mexotic.model.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long>{
		Optional<Pago> findByMonto(Double monto);
		Optional<Pago> findByFechaPago(Date fechaPago);
		Optional<Pago> findByMetodoPago(String metodoPago);
	
}
