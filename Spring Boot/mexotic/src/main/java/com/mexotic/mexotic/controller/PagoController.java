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
@RequestMapping (path="/api/pago/") //http://localhost:8080/api/pago/
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
	
	@GetMapping  (path ="{prodId}")  //http://localhost:8080/api/pago/1
	public Pago getPagos(@PathVariable ("prodId") Long idPago) {
		return service.getPago(idPago);
	}//GetPagos
	
	@DeleteMapping  (path ="{prodId}")  //http://localhost:8080/api/pago/1
	public Pago deletePago(@PathVariable ("prodId") Long idPago) {
		return service.deletePago(idPago);
	}//GetPagos
	
	@PostMapping
	public Pago addPago(@RequestBody Pago pago) {
		return service.addPago(pago);
	}//addPago
	
	@PutMapping  (path ="{prodId}")  //http://localhost:8080/api/pago/1
	public Pago updatePagos(@PathVariable ("prodId") Long idPago, 
			@RequestParam(required=false) Double monto,
			@RequestParam(required=false) Date fechaPago,
			@RequestParam(required=false) String metodoPago) {
		return service.updatePago(idPago, monto, fechaPago, metodoPago);
	}//PutPago
	
	
}//class Pago Controller
