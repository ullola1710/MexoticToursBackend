package com.mexotic.mexotic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO -Plain Old Java Object

@Entity
@Table(name = "Usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario", unique=true, nullable=false)
	private Long idUsuario;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String apellido;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String telefono;
	@Column(nullable=false)
	private String contrasena;
	@Column(name = "admin",nullable=false)
	private boolean admin;
	@Column(nullable=false)
	private String imgUsuario;
	


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
	}///constructor
	
	
	public Usuario () {	} //constructor vacio
	
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


