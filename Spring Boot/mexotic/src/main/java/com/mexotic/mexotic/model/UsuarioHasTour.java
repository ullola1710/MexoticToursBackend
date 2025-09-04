package com.mexotic.mexotic.model;

public class UsuarioHasTour {
	private Long id;
	private Long idUsuario;
	private Long idTour;
	
	private static long total=0;
    public UsuarioHasTour(Long idUsuario, Long idTour) {
        this.idUsuario = idUsuario;
        this.idTour = idTour;
        
        UsuarioHasTour.total++;
        this.id = UsuarioHasTour.total;
    }
    
    public UsuarioHasTour() {
    	UsuarioHasTour.total++;
        this.id = UsuarioHasTour.total;
    }
    
    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdTour() {
		return idTour;
	}

	public void setIdTour(Long idTour) {
		this.idTour = idTour;
	}

	@Override
	public String toString() {
		return "UsuarioHasTour [idUsuario=" + idUsuario + ", idTour=" + idTour + "]";
	}
    
    
}
