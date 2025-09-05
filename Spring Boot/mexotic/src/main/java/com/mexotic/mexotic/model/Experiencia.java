package com.mexotic.mexotic.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="experiencias")
public class Experiencia {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(nullable=false)
	private String comentario;
	@Column(nullable=false)
	private Integer calificacion;
	@Column(nullable=false)
	private Date fecha;
	@Column(nullable=false)
	private Tour tour;
	@Column(nullable=false)
	private Usuario usuario;
	
	

	public Experiencia(String comentario, Integer calificacion, Date fecha, Tour tour, Usuario usuario) {	
		super();
		this.comentario = comentario;
		this.calificacion = calificacion;
		this.fecha = fecha;
		this.tour = tour;
		this.usuario = usuario;
	}//constructor

		public Experiencia() {	
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



	public Tour getTour() {
		return tour;
	}//getTour



	public void setTour(Tour tour) {
		this.tour = tour;
	}//setTour



	public Usuario getUsuario() {
		return usuario;
	}//getUsuario



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}//setUsuario



	public Long getId() {
		return id;
	}//getId



	public Date getFecha() {
		return fecha;
	}//getFecha


	@Override
	public String toString() {
		return "Experiencia [id=" + id + ", comentario=" + comentario + ", calificacion=" + calificacion + ", fecha="
				+ fecha + "]";
	}//toString
	

}//class Experiencia
