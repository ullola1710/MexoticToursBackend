package com.mexotic.mexotic.dto;

import java.util.List;

import com.mexotic.mexotic.model.Reserva;
import com.mexotic.mexotic.model.Tour;

public class ReservaRequest {
	
	private Reserva reserva;
    private List<Tour> tours;
    private List<Integer> cantidades;
 

	public Reserva getReserva() {
		return reserva;
	} // getReserva
	
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	} // setReserva
	
	public List<Tour> getTours() {
		return tours;
	} // getTours
	
	public void setTours(List<Tour> tours) {
		this.tours = tours;
	} // setTours
	
	public List<Integer> getCantidades() {
		return cantidades;
	} // getCantidades

	public void setCantidades(List<Integer> cantidades) {
		this.cantidades = cantidades;
	} // setCantidades
	
} // class ReservaRequest
