package com.mexotic.mexotic.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mexotic.mexotic.model.Experiencia;
import com.mexotic.mexotic.repository.ExperienciasRepository;

@Service
public class ExperienciaService {
	private final ExperienciasRepository repository;

	@Autowired
	public ExperienciaService(ExperienciasRepository repository) {
		this.repository = repository;
	}//constructor
	
	
	public List<Experiencia> getExperiences() {
		return repository.findAll();
	}//getExperiences
	
	public Experiencia getExperience(Long id) {
		return repository.findById(id).orElseThrow(
				()->new IllegalArgumentException("La experiencia con el id [" + id
						+ "] no existe")
				);
	}//getExperience
	

	public Experiencia deleteExperience(Long id) {
		Experiencia exp = null;
		if (repository.existsById(id)) {
			exp = repository.findById(id).get();
				repository.deleteById(id);
			}//if
		return exp;
	}//deleteExperience

	public Experiencia addExperience(Experiencia experiencia) {
		Optional<Experiencia> exp =
				repository.findById(experiencia.getId());
		if (exp.isEmpty()) {
			repository.save(experiencia);
		} else {
			experiencia = null;
		}
		return experiencia;
	}//addExperience
	
	public Experiencia updateExperience(Long id, String comentario,
			Integer calificacion) {
		Experiencia exp = null;
			if (repository.existsById(id)) {
				exp = repository.findById(id).get();
				if(comentario!=null) exp.setComentario(comentario);
				if(calificacion!=null)exp.setCalificacion(calificacion);
					return repository.save(exp);
				} else {
					exp=null;
				}
			return exp;
	}//updateExperience

	
}//class ExperienciaService
