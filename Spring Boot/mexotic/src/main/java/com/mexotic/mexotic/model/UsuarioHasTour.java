package com.mexotic.mexotic.model;

public class UsuarioHasTour {
	private Long id;
	private Long fk_idUsuario;
	private Long fk_idTour;
	
	private static long total=0;
	
    public UsuarioHasTour(Long fk_idUsuario, Long fk_idTour) {
        this.fk_idUsuario = fk_idUsuario;
        this.fk_idTour = fk_idTour;
        
        UsuarioHasTour.total++;
        this.id = UsuarioHasTour.total;
    }//constructor
    
    public UsuarioHasTour() {
    	UsuarioHasTour.total++;
        this.id = UsuarioHasTour.total;
    }//constructor vacío     

	public Long getId() {
		return id;
	}//getId

	public void setId(Long id) {
		this.id = id;
	}//setId

	public Long getFk_idUsuario() {
		return fk_idUsuario;
	}//get Fk_idUsuario

	public void setFk_idUsuario(Long fk_idUsuario) {
		this.fk_idUsuario = fk_idUsuario;
	}//set_Fk_idUsuario

	public Long getFk_idTour() {
		return fk_idTour;
	}//getFk_idTour

	public void setFk_idTour(Long fk_idTour) {
		this.fk_idTour = fk_idTour;
	}//setFk_idTour

	@Override
	public String toString() {
		return "UsuarioHasTour [id=" + id + ", fk_idUsuario=" + fk_idUsuario + ", fk_idTour=" + fk_idTour + "]";
	}//to String    
    
}//class Usuario
