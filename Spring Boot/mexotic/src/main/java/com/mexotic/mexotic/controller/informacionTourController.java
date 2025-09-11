package com.mexotic.mexotic.controller;
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

import com.mexotic.mexotic.model.InformacionTour;
import com.mexotic.mexotic.service.informacionTourService;



@RestController
@RequestMapping(path="/mexotic/tours/detalle-de-tour/")
public class informacionTourController {
	
	@Autowired
	private final informacionTourService service;

	public informacionTourController(informacionTourService service) {
		this.service=service;
	}//contructor
	
	@GetMapping
	public List<InformacionTour>getInformacionTour(){
		return service.getInformacionTours();
	} // get
	
	@GetMapping (path="/tour/{tourId}")
	public InformacionTour getInformacionTourByTourId(@PathVariable("tourId")Long tourId) {
		return service.getInfoTourByTourId(tourId);
	}//busqueda por id
	
	@DeleteMapping (path="{idInformacionTour}")
	public InformacionTour deleteInformacionTour(@PathVariable("idInformacionTour")Long idInformacionTour) {
		return service.deleteInfoTour(idInformacionTour);
	}//eliminar 
	
	@PostMapping
	public InformacionTour addInformacionTour(@RequestBody InformacionTour infoTour) {
		return service.addInformacionTour(infoTour);
	}//publicar
	
	@PutMapping (path="{idInformacionTour}")
	public InformacionTour updateInformacionTour(@PathVariable("idInformacionTour")Long idInformacionTour, 
			@RequestParam(required=false) String salida,
			@RequestParam(required=false) String regresoAprox,
			@RequestParam(required=false) String frecuencia,
			@RequestParam(required=false) String grupos){
		return service.updateInfoTour(salida, regresoAprox, frecuencia, grupos, idInformacionTour);
			}//update
	
}//Class InformacionTourController
