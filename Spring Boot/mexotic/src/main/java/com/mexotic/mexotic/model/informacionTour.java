package com.mexotic.mexotic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Información Tour")
public class informacionTour {
	@Column(name="Salida", nullable=false)
	private String salida;
	@Column(name=" Regreso Aproximado", nullable=false)
	private String regresoAprox;
	@Column(name="Frecuencia", nullable=false)
	private String frecuencia;
	@Column(name="Grupos", nullable=false)
	private String grupos;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID Información Tour", unique=true, nullable=false)
	private Long idInformacionTour;
	
	
	//constructor
	public informacionTour(String salida, String regresoAprox, 
			String frecuencia, String grupos) {
		super();
		this.salida = salida;
		this.regresoAprox = regresoAprox;
		this.frecuencia = frecuencia;
		this.grupos = grupos;

		}//Contructor InformacionTour
	
	//Contructor vacio para nuevo informacionTour
	public informacionTour() {
		
	}//Contructor InformacionTour

	//getters and setters
	public String getSalida() {
		return salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}

	public String getRegresoAprox() {
		return regresoAprox;
	}

	public void setRegresoAprox(String regresoAprox) {
		this.regresoAprox = regresoAprox;
	}

	public String getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}

	public String getGrupos() {
		return grupos;
	}

	public void setGrupos(String grupos) {
		this.grupos = grupos;
	}

//	public static int getCantInfoTour() {
//		return cantInfoTour;
//	}
	

	public Long getIdInformacionTour() {
		return idInformacionTour;
	}

	
//to String

	@Override
	public String toString() {
		return "informacionTour [salida=" + salida + ", regresoAprox=" + regresoAprox + ", frecuencia=" + frecuencia
				+ ", grupos=" + grupos + ", idInformacionTour=" + idInformacionTour + "]";
	}//toString
	

}//Class Informacion tour

