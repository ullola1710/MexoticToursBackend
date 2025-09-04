package com.mexotic.mexotic.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mexotic.mexotic.model.Pago;
import com.mexotic.mexotic.service.PagoService;

@RestController
<<<<<<< HEAD
@RequestMapping (path="/api/pago/") //http://localhost:8080/api/pago/
=======
@RequestMapping (path="/mexotic/pago/") //http://localhost:8080/mexotic/pago/
>>>>>>> ad0d5f17abd0049a99810c351bce4bea8f0a0519
public class PagoController {
	private final PagoService service; 
	@Autowired
	public PagoController(PagoService service) {
		this.service=service; 
	}//Constructor

	@GetMapping
	public List<Pago> getPago() {
		return service.getPagos();
	}//Listgetpago
	
<<<<<<< HEAD
	@GetMapping  (path ="{prodId}")  //http://localhost:8080/api/pago/1
	public Pago getPagos(@PathVariable ("prodId") Long idPago) {
		return service.getPago(idPago);
	}//GetPagos
	
	@DeleteMapping  (path ="{prodId}")  //http://localhost:8080/api/pago/1
	public Pago deletePago(@PathVariable ("prodId") Long idPago) {
=======
	@GetMapping  (path ="{pagoId}")  //http://localhost:8080/api/pago/1
	public Pago getPagos(@PathVariable ("pagoId") Long idPago) {
		return service.getPago(idPago);
	}//GetPagos
	
	@DeleteMapping  (path ="{pagoId}")  //http://localhost:8080/api/pago/1
	public Pago deletePago(@PathVariable ("pagoId") Long idPago) {
>>>>>>> ad0d5f17abd0049a99810c351bce4bea8f0a0519
		return service.deletePago(idPago);
	}//GetPagos
	
	@PostMapping
	public Pago addPago(@RequestBody Pago pago) {
		return service.addPago(pago);
	}//addPago
	
<<<<<<< HEAD
	@PutMapping  (path ="{prodId}")  //http://localhost:8080/api/pago/1
	public Pago updatePagos(@PathVariable ("prodId") Long idPago, 
=======
	@PutMapping  (path ="{pagoId}")  //http://localhost:8080/api/pago/1
	public Pago updatePagos(@PathVariable ("pagoId") Long idPago, 
>>>>>>> ad0d5f17abd0049a99810c351bce4bea8f0a0519
			@RequestParam(required=false) Double monto,
			@RequestParam(required=false) Date fechaPago,
			@RequestParam(required=false) String metodoPago) {
		return service.updatePago(idPago, monto, fechaPago, metodoPago);
	}//PutPago
	
	
}//class Pago Controller
