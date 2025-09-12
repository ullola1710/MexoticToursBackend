package com.mexotic.mexotic.dto;

import java.util.Date;

public class ExperienciaDTO {

	private String comentario;
    private Integer calificacion;
    private Date fecha;
    private String usuario;
    private String imgExperiencia;
    private String tourName;

    // Constructor
    public ExperienciaDTO(String comentario, Integer calificacion, Date date, String usuario, String imgExperiencia, String tourName) {
        this.comentario = comentario;
        this.calificacion = calificacion;
        this.fecha = date;
        this.usuario = usuario;
        this.imgExperiencia = imgExperiencia;
        this.tourName = tourName;
    }

	public String getComentario() {
		return comentario;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getImgExperiencia() {
		return imgExperiencia;
	}

	public String getTourName() {
		return tourName;
	}
	
	
    
} // class ExperienciaDTO
