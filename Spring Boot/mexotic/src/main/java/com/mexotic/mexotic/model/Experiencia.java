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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Experiencia")
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
	@JoinColumn(name = "fk_idTour", referencedColumnName = "idTour", nullable = false)
	@JsonBackReference("tour-experiencias")  
	private Tour fkIdTour;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_idUsuario", referencedColumnName = "idUsuario", nullable = false)
	@JsonBackReference("usuario-experiencias")
	private Usuario fkIdUsuario;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "R_idTour", referencedColumnName = "idTour")
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // ← Mantén esta anotación
//    private Tour tour;
//
//    @ManyToOne
//    @JoinColumn(name = "IdJusario", referencedColumnName = "idUsuario", nullable = false)
//    @JsonIgnore // ← Cambia a @JsonIgnore
//    private Usuario usuario;

	@PrePersist
	protected void onCreate() {
		if (fecha == null) {
			fecha = new Date();
		}
	}

	public Experiencia(String comentario, Integer calificacion, Date fecha, Tour fkIdTour, Usuario fkIdUsuario) {
		super();
		this.comentario = comentario;
		this.calificacion = calificacion;
		this.fecha = fecha;
		this.fkIdTour = fkIdTour;
		this.fkIdUsuario = fkIdUsuario;
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
		return fkIdTour;
	}// getTour FK
	
	public void setTour(Tour fkIdTour) {
		this.fkIdTour = fkIdTour;
	}

	public Usuario getUsuario() {
		return fkIdUsuario;
	}// getusuario FK

	public void setUsuario(Usuario fkIdUsuario) {
		this.fkIdUsuario = fkIdUsuario;
	}

	@Override
	public String toString() {
		return "Experiencia [id=" + idExperiencia + ", comentario=" + comentario + ", calificacion=" + calificacion
				+ ", fecha=" + fecha + "]";
	}// toString

}// class Experiencia
