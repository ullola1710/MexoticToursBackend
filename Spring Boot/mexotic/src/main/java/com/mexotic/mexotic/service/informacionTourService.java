package com.mexotic.mexotic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mexotic.mexotic.model.informacionTour;
import com.mexotic.mexotic.repository.informacionTourRepository;

import java.util.List;
import java.util.Optional;


@Service
public class informacionTourService {

	private final informacionTourRepository infoTourRepository;
	@Autowired
	public informacionTourService(informacionTourRepository infoTourrepository) {
		this.infoTourRepository=infoTourrepository;
	}//Constructor
	
	//Getall
	public List<informacionTour>getInformacionTours(){
		return infoTourRepository.findAll();
	}//InformacionTourFindsAll
	
	//Get
	public informacionTour getInfoTour(Long idInformacionTour) {
		return infoTourRepository.findById(idInformacionTour).orElseThrow(
				()-> new IllegalArgumentException("El Id ["+idInformacionTour+"] no existe en Información Tours"));
			}//metodo findsById para obtener una infoTour por id
	
	public informacionTour addInformacionTour(informacionTour infoTour) {
		Optional<informacionTour> iTour = 
				infoTourRepository.findById(infoTour.getIdInformacionTour());
		if(iTour.isEmpty()) {
			infoTourRepository.save(infoTour);
		}else {
			infoTour=null;
		}return infoTour;
	}//Agrega nuevos informacionTour
	
	//Put
	public informacionTour updateInfoTour(String salida,String regresoAprox, String frecuencia, String grupos,Long idInformacionTour) {
		informacionTour tmp = null;
		if(infoTourRepository.existsById(idInformacionTour)) {
			informacionTour iTour = infoTourRepository.findById(idInformacionTour).get();
			if(salida!=null) iTour.setSalida(salida);
			if(regresoAprox!=null)iTour.setRegresoAprox(regresoAprox);
			if(frecuencia!=null)iTour.setFrecuencia(frecuencia);
			if(grupos!=null)iTour.setGrupos(grupos);
			infoTourRepository.save(iTour);
			tmp=iTour;
		}//si algun campo no es null
		return tmp;
	}//UpdateInformacionTours
	
	public informacionTour deleteInfoTour(Long idInformacionTour) {
		informacionTour tmp = null;
		if(infoTourRepository.existsById(idInformacionTour)) {
			tmp=infoTourRepository.findById(idInformacionTour).get();
			infoTourRepository.deleteById(idInformacionTour);
		}//ifExistById
		return tmp;
	}//Delete informacionTour
	
}//Class InformacionTourService
