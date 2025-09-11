package com.mexotic.mexotic.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "experiencia")
public class Experiencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idExperiencia", unique = true, nullable = false)
	private Long idExperiencia;
	@Column(nullable = false)
	private String comentario;
	@Column(nullable = false)
	private Integer calificacion;
	@Column(nullable = false)
	private Date fecha;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_idTour")
	@com.fasterxml.jackson.annotation.JsonIgnoreProperties({ "experiencias" }) // evita bucle
	private Tour tour;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_idUsuario")
	@com.fasterxml.jackson.annotation.JsonIgnoreProperties({ "reservas", "experiencias", "contrasena" })
	private Usuario usuario;

	@PrePersist
	protected void onCreate() {
		if (fecha == null) {
			fecha = new Date();
		}
	}

	public Experiencia(String comentario, Integer calificacion, Date fecha, Tour tour, Usuario usuario) {
		super();
		this.comentario = comentario;
		this.calificacion = calificacion;
		this.fecha = fecha;
		this.tour = tour;
		this.usuario = usuario;
	}// constructor

	public Experiencia() {
	}// constructor

	public String getComentario() {
		return comentario;
	}// getComentario

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}// setComentario

	public Integer getCalificacion() {
		return calificacion;
	}// getCalificacion

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}// setCalificacion

	public Long getIdExperiencia() {
		return idExperiencia;
	}// getId

	public void setIdExperiencia(Long idExperiencia) {
		this.idExperiencia = idExperiencia;
	}

	public Date getFecha() {
		return fecha;
	}// getFecha

	public Tour getTour() {
		return tour;
	}// getTour FK

	public Usuario getUsuario() {
		return usuario;
	}// getusuario FK

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Experiencia [id=" + idExperiencia + ", comentario=" + comentario + ", calificacion=" + calificacion
				+ ", fecha=" + fecha + "]";
	}// toString

}// class Experiencia
