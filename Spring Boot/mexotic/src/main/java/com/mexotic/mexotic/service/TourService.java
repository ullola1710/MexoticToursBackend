package com.mexotic.mexotic.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.mexotic.mexotic.model.Categoria;
import com.mexotic.mexotic.model.Estado;
import com.mexotic.mexotic.model.Tour;
import com.mexotic.mexotic.repository.TourRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourService {
    
	private TourRepository repository;

    @Autowired
    public TourService(TourRepository repository){
        this.repository = repository;
    } // Constructor

	public List<Tour> getTours() {
		return repository.findAll();
	} // getTours

	public Tour getTour(Long idTour) {
		return repository.findById(idTour).orElseThrow(
				() -> new IllegalArgumentException("El tour con el id[" + idTour
						+ "] no existe")
				);
	} // getTour

	public Tour deleteTour(Long idTour) {
		Tour tmpTour = null;
		if(repository.existsById(idTour)) {
			tmpTour = repository.findById(idTour).get();
			repository.deleteById(idTour);
		} // if
		return tmpTour;
	} // deleteTour

	public Tour addTour(Tour tour) {
		Optional<Tour> t = repository.findByNombre(tour.getNombre());
		if(t.isEmpty()) {
			repository.save(tour);
		} else {
			tour = null;
		} // if
		return tour;
	} // addTour

	public Tour updateTour(Long idTour, String nombre, Estado estado, String ciudad, String imgPortada, String img,
			String descripcion, String duracion, Double precio, Double precioExclusivo, String incluye,
			Categoria categoria) {
		Tour tmpTour = null;
		if(repository.existsById(idTour)) {
			Tour t = repository.findById(idTour).get();
			if(nombre != null) t.setNombre(nombre);
			if(estado != null) t.setEstado(estado);
			if(ciudad != null) t.setCiudad(ciudad);
			if(imgPortada != null) t.setImgPortada(imgPortada);
			if(img != null) t.setImg(img);
			if(descripcion != null) t.setDescripcion(descripcion);
			if(duracion != null) t.setDuracion(duracion);
			if(precio != null) t.setPrecio(precio);
			if(precioExclusivo != null) t.setPrecioExclusivo(precioExclusivo);
			if(incluye != null) t.setIncluye(incluye);
			if(categoria != null) t.setCategoria(categoria);
			repository.save(t);
			tmpTour = t;
		} // if
		return tmpTour;
	} // updateTour


} // class TourService

