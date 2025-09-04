package com.mexotic.mexotic.model;

public class informacionTour {
	
	private String salida;
	private String regresoAprox;
	private String frecuencia;
	private String grupos;
	private Long idInformacionTour;
	
	private static long cantInfoTour = 0;
	
	//constructor
	public informacionTour(String salida, String regresoAprox, 
			String frecuencia, String grupos) {
		super();
		this.salida = salida;
		this.regresoAprox = regresoAprox;
		this.frecuencia = frecuencia;
		this.grupos = grupos;
		
		//idInformacionTour
		informacionTour.cantInfoTour++;
		this.idInformacionTour = informacionTour.cantInfoTour;
		}//Contructor InformacionTour
	
	//Contructor vacio para nuevo informacionTour
	public informacionTour() {
		informacionTour.cantInfoTour++;
		this.idInformacionTour=informacionTour.cantInfoTour;
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

