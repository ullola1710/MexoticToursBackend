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

import com.mexotic.mexotic.model.Experiencia;
import com.mexotic.mexotic.service.ExperienciaService;


@RestController
@RequestMapping(path= "/mexotic/experiencias/") // http://localhost:8080/api/experiencias/
public class ExperienciaController {
	private final ExperienciaService service;
	@Autowired
	public ExperienciaController(ExperienciaService service) {
		this.service=service;
	}
	
	//GET
	@GetMapping
	public List<Experiencia> getExperiencias(){
		return service.getExperiences();
	}//getExperiencias
	
	@GetMapping(path="{expId}") // http://localhost:8080/api/experiencias/1
	public Experiencia getExperiencia(@PathVariable("expId") Long id) {
		return service.getExperience(id);
	}//getexperiencia
	
	
	//DELETE
	@DeleteMapping(path="{expId}") // http://localhost:8080/api/experiencias/1
	public Experiencia deleteExperiencia(@PathVariable("expId") Long id) {
		return service.deleteExperience(id);
	}//deleteExperiencias
	
	//POST
	@PostMapping
	public Experiencia addExperiencia(@RequestBody Experiencia experiencia) {
		return service.addExperience(experiencia);
	}//addExperiencia

	
	//PUT
	@PutMapping(path="{expId}") // http://localhost:8080/api/experiencias/1
	public Experiencia updateExperiencia(@PathVariable ("expId") Long id,
			@RequestParam(required=false) String comentario,
			@RequestParam(required=false) Integer calificacion,
			@RequestParam(required=false) Date fecha 
			//@RequestParam(required=false) Tours tour,
			//@RequestParam(required=false) Usuarios usuario
			){
		return service.updateExperience(id, comentario, calificacion, fecha);
	}//updateExperiencia
	
}//class ExperienciaController
