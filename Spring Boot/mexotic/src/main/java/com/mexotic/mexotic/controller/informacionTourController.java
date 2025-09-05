package com.mexotic.mexotic.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mexotic.mexotic.model.informacionTour;
import com.mexotic.mexotic.service.informacionTourService;



@RestController
@RequestMapping(path="/tours/DetalleDeTour/")
public class informacionTourController {
	
	@Autowired
	private final informacionTourService service;

	public informacionTourController(informacionTourService service) {
		this.service=service;
	}//contructor
	
	@RequestMapping
	public List<informacionTour>getInformacionTour(){
		return service.getInformacionTours();
	}
	
	@RequestMapping (path="{idInformacionTour}")
	public informacionTour getInformacionTour(@PathVariable("idInformacionTour")Long idInformacionTour) {
		return service.getInfoTour(idInformacionTour);
	}//busqueda por id
	
	@DeleteMapping (path="{idInformacionTour}")
	public informacionTour deleteInformacionTour(@PathVariable("idInformacionTour")Long idInformacionTour) {
		return service.deleteInfoTour(idInformacionTour);
	}//eliminar 
	
	@PostMapping
	public informacionTour addInformacionTour(@RequestBody informacionTour infoTour) {
		return service.addInformacionTour(infoTour);
	}//publicar
	
	@PutMapping (path="{idInformacionTour}")
	public informacionTour updateInformacionTour(@PathVariable("idInformacionTour")Long idInformacionTour, 
			@RequestParam(required=false) String salida,
			@RequestParam(required=false) String regresoAprox,
			@RequestParam(required=false) String frecuencia,
			@RequestParam(required=false) String grupos){
		return service.updateInfoTour(salida, regresoAprox, frecuencia, grupos, idInformacionTour);
			}//update
	
}//Class InformacionTourController
