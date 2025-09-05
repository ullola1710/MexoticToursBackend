package com.mexotic.mexotic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mexotic.mexotic.model.Pago;
import com.mexotic.mexotic.repository.PagoRepository;

@Service
public class PagoService {
		private final PagoRepository repository;
		@Autowired
		public PagoService(PagoRepository repository) {
			//Double monto, Date fechaPago, String metodoPago
			this.repository=repository; 
			}//Constructor 
		
		public List<Pago> getPagos(){
			return repository.findAll(); 
		}//GetPagos

		public Pago getPago(Long idPago) {
			return repository.findById(idPago).orElseThrow(
					()-> new IllegalArgumentException("El producto con el id["+ idPago +"] no existe")
					
					);
					
				
		}//getPago

		
		
		
		public Pago deletePago(Long idPago) {
			Pago tmpPago = null;
			if(repository.existsById(idPago)) {
				tmpPago=repository.findById(idPago).get();
				repository.deleteById(idPago);
			}	
			return tmpPago;
		}//Delete pago
		
	
		public Pago addPago(Pago pago) {
			Optional<Pago> pag= repository.findByMonto(pago.getMonto());
			if(pag.isEmpty()) {
				repository.save(pago);
			} else {
				pago = null; 
			}//if
			return pago; 
			}//addPagos

	

		
		
		
}//class PagoService 
