package com.mexotic.mexotic.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mexotic.mexotic.dto.ExperienciaDTO;
import com.mexotic.mexotic.model.Experiencia;
import com.mexotic.mexotic.model.Usuario;
import com.mexotic.mexotic.service.ExperienciaService;

@RestController
@RequestMapping(path = "/mexotic/experiencia") // http://localhost:8080/mexotictours/experiencia/
public class ExperienciaController {
	private final ExperienciaService service;

	@Autowired
	public ExperienciaController(ExperienciaService service) {
		this.service = service;
	}

	// GET
	@GetMapping({"", "/"})
    public List<ExperienciaDTO> listar() {
        List<Experiencia> experiencias = service.listarTodos();
        return experiencias.stream().map(this::toDTO).collect(Collectors.toList());
    }// getExperiencias// getExperiencias
	
//	@GetMapping({"", "/"})
//	public List<ExperienciaDTO> listar(@RequestParam(defaultValue = "0") int page,
//	                                   @RequestParam(defaultValue = "10") int size) {
//	    Page<Experiencia> experiencias = service.listar(PageRequest.of(page, size));
//	    return experiencias.stream().map(this::toDTO).collect(Collectors.toList());
//	}

	@GetMapping("/{expId}")
    public ExperienciaDTO getExperiencia(@PathVariable("expId") Long idExperiencia) {
        Experiencia exp = service.getExperience(idExperiencia);
        if (exp == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Experiencia no encontrada");
        }
        return toDTO(exp);
    } // getExperiencia

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
	
	private ExperienciaDTO toDTO(Experiencia exp) {
	    String tourName = (exp.getTour() != null) ? exp.getTour().getNombre() : "Tour";
	    String usuario = (exp.getUsuario() != null) ? exp.getUsuario().getNombre() : "Anónimo";

	    return new ExperienciaDTO(
	            exp.getComentario(),
	            exp.getCalificacion(),
	            exp.getFecha(), 
	            usuario,
	            exp.getImgExperiencia(),
	            tourName
	    );
	} // toDTO

	
}// class ExperienciaController
