package com.mexotic.mexotic.informacionTour.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.mexotic.mexotic.informacionTour.model.informacionTour;


@Service
public class informacionTourService {

	//instancia de la informacionTour List
	private final ArrayList<informacionTour> listaInfoTours = new ArrayList<informacionTour>();
	
	//se crea la informacion de los tours
	@Autowired
	public informacionTourService() {
		listaInfoTours.add(new informacionTour("11:00 pm"," 2:30 pm","Sábado - Domingo (Si gustas algún dia en especifico puedes personalizar el tour)","Apto para cualquier edad, interesado por conocer un poco mas de la historia y arquitectura que nuestra bella Ciudad de México tiene."));
		listaInfoTours.add(new informacionTour("7:30 pm","10.30 pm","Martes, Jueves,Viernes,Sábado","Apto para cualquier edad, que tenga interés por conocer las leyendas de Querétaro"));
		listaInfoTours.add(new informacionTour("9:00 am","8:00 pm","Viernes,Sábado,Domingo; también dias festivos y vacaciones (consulta disponibilidad)","Grupos pequeños para atención personalizada. ¡Reserva con anticipación!"));
		listaInfoTours.add(new informacionTour("6:30 pm","10.30 pm","Viernes,Sábado","Personas que esten interesadas en la degustación de la cerveza artesanal, No apto para niños"));
		listaInfoTours.add(new informacionTour("9:00 am","07.00 pm","Viernes,Sábado","Apto para cualquier persona que tenga un amor por el vino, No apto para menores de edad"));
		listaInfoTours.add(new informacionTour("8:30 am","03.00 pm","Opera todo el año; en feriados puede haber variaciones de aforo en mercados","Para personas interesas en una degustación de la comida y antojitos tradicionales"));
		listaInfoTours.add(new informacionTour("11:00 am","07.00 pm","Mejor disponibilidad en temporada baja (enero–marzo). Itinerario puede variar por agenda de la exposición y disponibilidad del venue musical","Apto para todas las edades, menores acompañados"));
		listaInfoTours.add(new informacionTour("8:00 am","06.00 pm","Todos los sábados y domingos de acuerdo a la disponibilidad de cupo.","Mayores de edad con identificación oficial"));
		listaInfoTours.add(new informacionTour("7:00 pm","01.00 am","Todos los sábados y domingos de acuerdo a la disponibilidad de cupo.","Mayores de edad con identificación oficial"));
		listaInfoTours.add(new informacionTour("10:00 am","02.00 pm","De martes a domingo, excepto días festivos oficiales.","Recomendado para amantes del arte, estudiantes y familias."));
	}//Arraylist
	
	public List<informacionTour>getInformacionTours(){
		return listaInfoTours;
	}//getListaInfoTours
	
	
	public informacionTour getInfoTour(Long idInformacionTour) {
		informacionTour tmp = null;
		for(informacionTour infoTour:listaInfoTours) {
			if(infoTour.getIdInformacionTour()== idInformacionTour) {
				tmp=infoTour;
				break;
			}//if
		}//foreach
		return tmp;
	}//metodo get para obtener una infoTour por id
	
	public informacionTour addInformacionTour(informacionTour infoTour) {
		listaInfoTours.add(infoTour);
		return infoTour;
	}//Agrega nuevos informacionTour
	
	public informacionTour updateInfoTour(String salida,String regresoAprox, String frecuencia, String grupos,Long idInformacionTour) {
		informacionTour tmp = null;
		for(informacionTour infoTour:listaInfoTours) {
			if(infoTour.getIdInformacionTour()==idInformacionTour) {
				if(salida!=null) infoTour.setSalida(salida);
				if(regresoAprox!=null) infoTour.setRegresoAprox(regresoAprox);
				if(frecuencia!=null) infoTour.setFrecuencia(frecuencia);
				if(grupos!=null) infoTour.setGrupos(grupos);
				tmp = infoTour;
				break;
			}//if para validar si hay campos a actualizar
		}//foreach
		return tmp;
	}//UpdateInformacionTours
	
	public informacionTour deleteInfoTour(Long idInformacionTour) {
		informacionTour tmp = null;
		for(informacionTour infoTour:listaInfoTours) {
			if(infoTour.getIdInformacionTour()==idInformacionTour) {
				tmp=infoTour;
				listaInfoTours.remove(idInformacionTour);
				break;
			}//if si encuentra coincidencias
		}//foreach
		return tmp;
	}//Delete informacionTour
}
