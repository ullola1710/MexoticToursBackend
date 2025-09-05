package com.mexotic.mexotic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.mexotic.mexotic.model.Pago;
import com.mexotic.mexotic.service.PagoService;

@RestController


@RequestMapping (path="/mexotic/pago/") //http://localhost:8080/mexotic/pago/
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
	

	@GetMapping  (path ="{pagoId}")  //http://localhost:8080/api/pago/1
	public Pago getPagos(@PathVariable ("pagoId") Long idPago) {
		return service.getPago(idPago);
	}//GetPagos
	
	@DeleteMapping  (path ="{pagoId}")  //http://localhost:8080/api/pago/1
	public Pago deletePago(@PathVariable ("pagoId") Long idPago) {

		return service.deletePago(idPago);
	}//GetPagos
	
	@PostMapping
	public Pago addPago(@RequestBody Pago pago) {
		return service.addPago(pago);
	}//addPago
	

	
	
	
}//class Pago Controller
