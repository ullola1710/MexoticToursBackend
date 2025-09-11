package com.mexotic.mexotic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="InformacionTour")
public class InformacionTour {
//	@Column(name="Salida", nullable=false)
	@Column(unique=true, nullable=false)
	private String salida;
//	@Column(name=" RegresoAproximado", nullable=false)
	@Column(unique=true, nullable=false)
	private String regresoAprox;
//	@Column(name="Frecuencia", nullable=false)
	@Column(unique=true, nullable=false)
	private String frecuencia;
//	@Column(name="Grupos", nullable=false)
	@Column(unique=true, nullable=false)
	private String grupos;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="IDInformaciónTour", unique=true, nullable=false)
	@Column(unique=true, nullable=false)
	private Long idInformacionTour;
	
	 @OneToOne
	 @JoinColumn(name = "fk_idTour", referencedColumnName = "idTour", nullable = false, unique = true)
	 private Tour tour;

	
	//constructor
	public InformacionTour(String salida, String regresoAprox, 
			String frecuencia, String grupos, Tour tour) {
		this.salida = salida;
		this.regresoAprox = regresoAprox;
		this.frecuencia = frecuencia;
		this.grupos = grupos;
		this.tour = tour;

		}//Contructor InformacionTour
	
	//Contructor vacio para nuevo informacionTour
	public InformacionTour() { }//Contructor InformacionTour

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

	public void setIdInformacionTour(Long idInformacionTour) {
		this.idInformacionTour = idInformacionTour;
	}

	public Tour getTour() {
		return tour;
	}
	
	public void setTour(Tour tour) {
		this.tour = tour;
	}

	//to String
	@Override
	public String toString() {
		return "informacionTour [salida=" + salida + ", regresoAprox=" + regresoAprox + ", frecuencia=" + frecuencia
				+ ", grupos=" + grupos + ", idInformacionTour=" + idInformacionTour + "]";
	}//toString
	

}//Class Informacion tour

