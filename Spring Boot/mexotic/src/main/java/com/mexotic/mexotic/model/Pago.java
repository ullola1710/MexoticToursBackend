package com.mexotic.mexotic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idPago")
@Entity
@Table(name = "Pago")
public class Pago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPago", unique = true, nullable = false)
	private Long idPago;
	@Column(nullable = false)
	private Double monto;
	@Column(nullable = false)
	private Date fechaPago;
	@Column(nullable = false)
	private String metodoPago;

	@OneToOne
    @JoinColumn(name = "fk_idReserva", referencedColumnName = "idReserva")
    @JsonBackReference 
    private Reserva reserva;

	// Constructor
	public Pago(Double monto, Date fechaPago, String metodoPago, Reserva reserva) {
		super();
		this.monto = monto;
		this.fechaPago = fechaPago;
		this.metodoPago = metodoPago;
		this.reserva = reserva;

	}// Constructor

	public Pago() {
	}// constructor vacio para crear nuevos pagos desde un post

	// Getters And Setters
	public Long getIdPago() {
		return idPago;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}// GettersAndSetters

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	// toString
	@Override
	public String toString() {
		return "Pago [idPago=" + idPago + ", monto=" + monto + ", fechaPago=" + fechaPago + ", metodoPago=" + metodoPago
				+ "]";
	}// toString

}
