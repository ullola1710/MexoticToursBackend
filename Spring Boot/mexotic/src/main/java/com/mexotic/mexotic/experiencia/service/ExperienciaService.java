package com.mexotic.mexotic.experiencia.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mexotic.mexotic.experiencia.model.Experiencia;
//import com.mexotic.mexotic.experiencia.model.Tours;
//import com.mexotic.mexotic.experiencia.model.Usuario;

@Service
public class ExperienciaService {
	private final ArrayList<Experiencia> lista = new ArrayList<Experiencia>();

	@Autowired
	public ExperienciaService() {
//		lista.add(new Experiencia("\"Increíble aventura en las tierras agaveras. Explorar las antiguas destilerías y probar el tequila auténtico fue inolvidable. El paisaje declarado Patrimonio de la UNESCO es de ensueño, y el tour incluyó catas que nos transportaron a otro mundo. ¡No te lo pierdas!\"", "5", "Tour Tequila", "Paola S."));
//		lista.add(new Experiencia("\"¡Una noche mágica llena de misterios! El recorrido por las calles de Querétaro con las leyendas del Marqués y la Celda de Satanás fue escalofriante y fascinante. El guía lo hizo tan vivo que parecía estar en el pasado. ¡Recomendado para amantes de la historia!\"", "5", "Tour de Leyendas", "Fátima R."));
//		lista.add(new Experiencia("\"Una joya cultural en el corazón de México. La colección desde el siglo XVI hasta el XX es impresionante, con obras maestras que te dejan sin aliento. El edificio histórico añade magia al recorrido. ¡Esencial para cualquier visitante a CDMX!\"", "5", "Visita al MUNAL", "Claudia V."));
//		lista.add(new Experiencia("\"Para los amantes del vino, este tour es perfecto. Visitamos viñedos increíbles, degustamos vinos exquisitos y aprendimos sobre la producción local. La combinación de paisajes y sabores fue espectacular, ideal para una escapada romántica. ¡Volveremos!\"", "5", "Ruta del Vino", "Luis T."));
//		
		lista.add(new Experiencia("\"Increíble aventura en las tierras agaveras. Explorar las antiguas destilerías y probar el tequila auténtico fue inolvidable. El paisaje declarado Patrimonio de la UNESCO es de ensueño, y el tour incluyó catas que nos transportaron a otro mundo. ¡No te lo pierdas!\"", 5, new Date()));
		lista.add(new Experiencia("\"¡Una noche mágica llena de misterios! El recorrido por las calles de Querétaro con las leyendas del Marqués y la Celda de Satanás fue escalofriante y fascinante. El guía lo hizo tan vivo que parecía estar en el pasado. ¡Recomendado para amantes de la historia!\"", 5, new Date()));
		lista.add(new Experiencia("\"Una joya cultural en el corazón de México. La colección desde el siglo XVI hasta el XX es impresionante, con obras maestras que te dejan sin aliento. El edificio histórico añade magia al recorrido. ¡Esencial para cualquier visitante a CDMX!\"", 5, new Date()));
		lista.add(new Experiencia("\"Para los amantes del vino, este tour es perfecto. Visitamos viñedos increíbles, degustamos vinos exquisitos y aprendimos sobre la producción local. La combinación de paisajes y sabores fue espectacular, ideal para una escapada romántica. ¡Volveremos!\"", 5, new Date()));
	}
	
	
	public List<Experiencia> getExperiences() {
		return lista;
	}//getExperiences
	
	public Experiencia getExperience(Long id) {
		Experiencia tmpExp = null;
		for (Experiencia exp : lista) {
			if (exp.getId()==id) {
				tmpExp=exp;
				break;
			}//if
		}//foreach
		return tmpExp;
	}//getExperience
	

	public Experiencia deleteExperience(Long id) {
		Experiencia tmpExp = null;
		for (Experiencia exp : lista) {
			if (exp.getId()==id) {
				tmpExp=exp;
				lista.remove(exp);
				break;
			}//if
		}//foreach
		return tmpExp;
	}//deleteExperience

	public Experiencia addExperience(Experiencia experiencia) {
		lista.add(experiencia);
		return experiencia;
	}//addExperience
	
	public Experiencia updateExperience(Long id, String comentario,
			//Integer calificacion, Date fecha, Tours tour, Usuario usuario) {
		Integer calificacion, Date fecha) {
		Experiencia tmpExp = null;
		for (Experiencia exp : lista) {
			if (exp.getId()==id) {
				if(comentario!=null) exp.setComentario(comentario);
				if(calificacion!=null) exp.setCalificacion(calificacion);
				if(fecha!=null) exp.setFecha(fecha);
				//if(tour!=null) exp.setTour(tour); 
				//if(usuario!=null) exp.setUsuario(usuario);
				tmpExp=exp;
				break;
			}//if
		}//foreach
		return tmpExp;
	}//updateExperience


	

}//class ExperienciaService
