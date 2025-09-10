package com.mexotic.mexotic.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="idReserva", referencedColumnName = "idUsuario") 
//	List<Reserva> reservas = new ArrayList<Reserva>();
	
	@OneToMany(mappedBy = "fkIdUsuario", cascade = CascadeType.ALL)
	private List<Reserva> reservas = new ArrayList<>();

	
//	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//	@JoinColumn(name="idExperiencia", referencedColumnName = "idUsuario") 
//	List<Experiencia> experiencias = new ArrayList<Experiencia>();
	
	@OneToMany(mappedBy = "usuario", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Experiencia> experiencias = new ArrayList<>();

	
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="fk_idUsuario", referencedColumnName = "idUsuario") 
//	List<UsuarioHasTour> usuarioHasTour  = new ArrayList<UsuarioHasTour>();

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "Usuario_has_Tour",joinColumns = 
	@JoinColumn(name = "fk_idUsuario"),inverseJoinColumns = @JoinColumn(name = "fk_idTour"))
	private Set<Tour> tours = new HashSet<Tour>();

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
		this.experiencias= new ArrayList<>();
	}///constructor
	
	public void addExperiencia(Experiencia experiencia) {
		this.experiencias.add(experiencia);
		experiencia.setUsuario(this);
	}
	
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
	
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public List<Experiencia> getExperiencias() {
		return experiencias;
	}


	public Set<Tour> getTours() {
		return tours;
	}


	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + ", contrasena=" + contrasena + ", admin=" + admin + ", imgUsuario="
				+ imgUsuario + "]";
	}//toString

	
	
}// class Usuario


