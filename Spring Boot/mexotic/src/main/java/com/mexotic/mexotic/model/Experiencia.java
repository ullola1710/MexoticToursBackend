package com.mexotic.mexotic.model;

import java.util.Date;

public class Experiencia {
	private Long id;
	private String comentario;
	private Integer calificacion;
	private Date fecha;
	//private Tours tour;
	//private Usuario usuario;
	
	private static long total=0;

	//public Experiencia(String comentario, Integer calificacion, Date fecha, Tours tour, Usuario usuario) {
		public Experiencia(String comentario, Integer calificacion, Date fecha) {	
		super();
		this.comentario = comentario;
		this.calificacion = calificacion;
		this.fecha = fecha;
		//this.tour = tour;
		//this.usuario = usuario;
		Experiencia.total++;
		this.id = Experiencia.total;
	}//constructor

		public Experiencia() {	
			Experiencia.total++;
			this.id = Experiencia.total;
		}//constructor
	

	public String getComentario() {
		return comentario;
	}//getComentario



	public void setComentario(String comentario) {
		this.comentario = comentario;
	}//setComentario



	public Integer getCalificacion() {
		return calificacion;
	}//getCalificacion



	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}//setCalificacion



//	public Tours getTour() {
//		return tour;
//	}//getTour



//	public void setTour(Tours tour) {
//		this.tour = tour;
//	}//setTour



//	public Usuario getUsuario() {
//		return usuario;
//	}//getUsuario



//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}//setUsuario



	public Long getId() {
		return id;
	}//getId



	public Date getFecha() {
		return fecha;
	}//getFecha
	
	public void setFecha(Date fecha) {
        this.fecha = fecha;
    }//setFecha


	@Override
	public String toString() {
		return "Experiencia [id=" + id + ", comentario=" + comentario + ", calificacion=" + calificacion + ", fecha="
				+ fecha + "]";
	}//toString
	

}//class Experiencia
