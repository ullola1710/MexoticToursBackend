package com.mexotic.mexotic.usuario.model;



public class Usuario {
	private Long idUsuario;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private String contrasena;
	private boolean admin;
	private String imgUsuario;
	

	private static long idTotal = 0;
	public Usuario(String nombre, String apellido, String email, String telefono, String contrasena, boolean admin,
			String imgUsuario) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.contrasena = contrasena;
		this.admin = admin;
		this.imgUsuario = imgUsuario;
		Usuario.idTotal++;
		this.idUsuario = Usuario.idTotal;
	}///constructor
	
	
	public Usuario () {
		Usuario.idTotal++;
		this.idUsuario = Usuario.idTotal;
	} //constructor 
	
	//getters and setters
	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre

	public String getApellido() {
		return apellido;
	}//getApellido

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}//setApellido

	public String getEmail() {
		return email;
	}//getEmail

	public void setEmail(String email) {
		this.email = email;
	}//setEmail

	public String getTelefono() {
		return telefono;
	}//getTelefono

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}//setTelefono

	public String getContrasena() {
		return contrasena;
	}//getContrasena

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}//setContrasena

	public boolean isAdmin() {
		return admin;
	} //getAdmin

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}//setAdmin

	public String getImgUsuario() {
		return imgUsuario;
	}//getImgUsuario

	public void setImgUsuario(String imgUsuario) {
		this.imgUsuario = imgUsuario;
	}//setImgUsuario

	public Long getIdUsuario() {
		return idUsuario;
	}//getIdUsuario


	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + ", contrasena=" + contrasena + ", admin=" + admin + ", imgUsuario="
				+ imgUsuario + "]";
	}//toString
	
}// class Usuario


