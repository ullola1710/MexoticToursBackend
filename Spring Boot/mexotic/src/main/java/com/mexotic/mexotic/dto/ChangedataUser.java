package com.mexotic.mexotic.dto;

public class ChangedataUser {
	private String contrasena;
	private String ncontrasena;
	private String telefono;
	private String imgUsuario;
	public ChangedataUser(String contrasena, String ncontrasena, String telefono, String imgUsuario) {
		super();
		this.contrasena = contrasena;
		this.ncontrasena = ncontrasena;
		this.telefono = telefono;
		this.imgUsuario = imgUsuario;
	}//constructor
	
	public ChangedataUser() {}//constructor vacio

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNcontrasena() {
		return ncontrasena;
	}

	public void setNcontrasena(String ncontrasena) {
		this.ncontrasena = ncontrasena;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getImgUsuario() {
		return imgUsuario;
	}

	public void setImgUsuario(String imgUsuario) {
		this.imgUsuario = imgUsuario;
	}

	@Override
	public String toString() {
		return "ChangedataUser [contrasena=" + contrasena + ", ncontrasena=" + ncontrasena + ", telefono=" + telefono
				+ ", imgUsuario=" + imgUsuario + "]";
	}
		
}//class ChangePassword
