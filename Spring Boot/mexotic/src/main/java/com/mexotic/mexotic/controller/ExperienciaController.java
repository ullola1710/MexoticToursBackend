package com.mexotic.mexotic.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.mexotic.mexotic.model.Usuario;
import com.mexotic.mexotic.service.ExperienciaService;

@RestController
@RequestMapping(path = "/mexotic/experiencia/") // http://localhost:8080/mexotictours/experiencia/
public class ExperienciaController {
	private final ExperienciaService service;

	@Autowired
	public ExperienciaController(ExperienciaService service) {
		this.service = service;
	}

	// GET
	public Page<Experiencia> listar(@RequestParam(required = false) Long idTour,
			org.springframework.data.domain.Pageable pageable) {
		return (idTour != null) ? service.listarPorTour(idTour, pageable) : service.listar(pageable);
	}// getExperiencias

	@GetMapping(path = "{expId}") // http://localhost:8080/mexotictours/experiencia/1
	public Experiencia getExperiencia(@PathVariable("expId") Long idExperiencia) {
		return service.getExperience(idExperiencia);
	}// getExperiencia

	// DELETE
	@DeleteMapping(path = "{expId}") // http://localhost:8080/mexotictours/experiencia/1
	public Experiencia deleteExperiencia(@PathVariable("expId") Long idExperiencia) {
		return service.deleteExperience(idExperiencia);
	}// deleteExperiencias

	// POST
	@PostMapping
	public Experiencia addExperiencia(@RequestBody Experiencia experiencia) {
		return service.addExperience(experiencia);
	}// addExperiencia

	// PUT
	@PutMapping(path = "{expId}") // http://localhost:8080/mexotictours/experiencia/1
	public Experiencia updateExperiencia(@PathVariable("expId") Long idExperiencia,
			@RequestParam(required = false) String comentario, 
			@RequestParam(required = false) Integer calificacion,
			@RequestParam(required = false) Usuario usuario) {
		return service.updateExperience(idExperiencia, comentario, calificacion, usuario);
	}// updateExperiencia

}// class ExperienciaController
