package com.mexotic.mexotic.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mexotic.mexotic.model.Experiencia;
import com.mexotic.mexotic.model.Usuario;
import com.mexotic.mexotic.repository.ExperienciasRepository;

@Service
public class ExperienciaService {
	private final ExperienciasRepository repository;

	@Autowired
	public ExperienciaService(ExperienciasRepository repository) {
		this.repository = repository;
	}//constructor
	
	// Para mejorar el rendimiento
	@Transactional(readOnly = true)
    public Page<Experiencia> listar(Pageable pageable) {
        return repository.findAll(pageable); // devuelve todas las experiencias paginadas
    } // listar

    @Transactional(readOnly = true)
    public Page<Experiencia> listarPorTour(Long idTour, Pageable pageable) {
        return repository.findByTour_IdTour(idTour, pageable); // filtra por idTour
    } // listarPorTour
	
    @Transactional(readOnly = true)
    public Experiencia getExperience(Long idExperiencia) {
        return repository.findById(idExperiencia).orElseThrow(
            () -> new IllegalArgumentException("La experiencia con id [" + idExperiencia + "] no existe")
        );
    } // getExperience
	
	@Transactional
	public Experiencia deleteExperience(Long idExperiencia) {
		Experiencia exp = null;
		if (repository.existsById(idExperiencia)) {
			exp = repository.findById(idExperiencia).get();
				repository.deleteById(idExperiencia);
			}//if
		return exp;
	}//deleteExperience

	@Transactional
	public Experiencia addExperience(Experiencia experiencia) {
		Optional<Experiencia> exp =
				repository.findByComentario(experiencia.getComentario());
		if (exp.isEmpty()) {
			repository.save(experiencia);
		} else {
			experiencia = null;
		}
		return experiencia;
	}//addExperience
	
	@Transactional
	public Experiencia updateExperience(Long idExperiencia, String comentario,
			Integer calificacion, Usuario idUsuario) {
		Experiencia exp = null;
			if (repository.existsById(idExperiencia)) {
				exp = repository.findById(idExperiencia).get();
				if(comentario!=null) exp.setComentario(comentario);
				if(calificacion!=null)exp.setCalificacion(calificacion);
				if(idUsuario!=null)exp.setUsuario(idUsuario);
				repository.save(exp);
				}//if
			return exp;
	}//updateExperience

	
}//class ExperienciaService
