package com.mexotic.mexotic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
//@NoArgsConstructor
@Entity
@Table(name = "Reserva_has_Tour")
public class ReservaHasTour {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private int cantidad;

	@ManyToOne
	@JoinColumn(name = "fk_idReserva", nullable = false)
	private Reserva reserva;

	@ManyToOne
	@JoinColumn(name = "fk_idTour", nullable = false)
	private Tour tour;

	public ReservaHasTour(Reserva reserva, Tour tour) {
		this.reserva = reserva;
		this.tour = tour;
	}

	public ReservaHasTour(int cantidad) {
		super();
		this.cantidad = cantidad;
	}

	public ReservaHasTour() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	@Override
	public String toString() {
		return "ReservaHasTours [id=" + id + ", reserva=" + reserva + ", tour=" + tour + "]";
	}

}

//private Long id;
//private Long idReserva;
//private Long idTour;
//
//private static long total=0;
//public ReservaHasTours(Long id, Long idReserva, Long idTour) {
//	this.id = id;
//	this.idReserva = idReserva;
//	this.idTour = idTour;
//	
//	ReservaHasTours.total++;
//	this.id = ReservaHasTours.total;
//}
//
//public ReservaHasTours() {
//	ReservaHasTours.total++;
//	this.id = ReservaHasTours.total;
//}
