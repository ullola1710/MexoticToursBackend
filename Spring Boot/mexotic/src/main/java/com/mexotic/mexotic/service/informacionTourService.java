package com.mexotic.mexotic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mexotic.mexotic.model.InformacionTour;
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
	@Transactional(readOnly = true)
	public List<InformacionTour>getInformacionTours(){
		return infoTourRepository.findAll();
	}//InformacionTourFindsAll
	
	//Get
	@Transactional(readOnly = true)
	public InformacionTour getInfoTour(Long idInformacionTour) {
		return infoTourRepository.findById(idInformacionTour).orElseThrow(
				()-> new IllegalArgumentException("El Id ["+idInformacionTour+"] no existe en Información Tours"));
			}//metodo findsById para obtener una infoTour por id
	
	@Transactional
	public InformacionTour addInformacionTour(InformacionTour infoTour) {
		Optional<InformacionTour> iTour = 
				infoTourRepository.findById(infoTour.getIdInformacionTour());
		if(iTour.isEmpty()) {
			return infoTourRepository.save(infoTour);
		}else {
			return null;
		}//if-else
	}//Agrega nuevos informacionTour
	
	//Put
	@Transactional
	public InformacionTour updateInfoTour(String salida,String regresoAprox, String frecuencia, String grupos,Long idInformacionTour) {
		InformacionTour tmp = null;
		if(infoTourRepository.existsById(idInformacionTour)) {
			InformacionTour iTour = infoTourRepository.findById(idInformacionTour).get();
			if(salida!=null) iTour.setSalida(salida);
			if(regresoAprox!=null)iTour.setRegresoAprox(regresoAprox);
			if(frecuencia!=null)iTour.setFrecuencia(frecuencia);
			if(grupos!=null)iTour.setGrupos(grupos);
			infoTourRepository.save(iTour);
			tmp=iTour;
		}//si algun campo no es null
		return tmp;
	}//UpdateInformacionTours
	
	@Transactional
	public InformacionTour deleteInfoTour(Long idInformacionTour) {
		InformacionTour tmp = null;
		if(infoTourRepository.existsById(idInformacionTour)) {
			tmp=infoTourRepository.findById(idInformacionTour).get();
			infoTourRepository.deleteById(idInformacionTour);
		}//ifExistById
		return tmp;
	}//Delete informacionTour
	
}//Class InformacionTourService
