package com.mexotic.mexotic.reservahastours.model;

public class ReservaHasTours {
	private Long id;
	private Long idReserva;
	private Long idTour;

	private static long total=0;
	public ReservaHasTours(Long id, Long idReserva, Long idTour) {
		this.id = id;
		this.idReserva = idReserva;
		this.idTour = idTour;
		
		ReservaHasTours.total++;
		this.id = ReservaHasTours.total;
	}
	
	public ReservaHasTours() {
		ReservaHasTours.total++;
		this.id = ReservaHasTours.total;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	public Long getIdTours() {
		return idTour;
	}

	public void setIdTours(Long idTour) {
		this.idTour = idTour;
	}

	@Override
	public String toString() {
		return "ReservaHasTours [id=" + id + ", idReserva=" + idReserva + ", idTours=" + idTour + "]";
	}

	
}
