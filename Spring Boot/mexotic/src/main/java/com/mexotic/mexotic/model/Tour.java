package com.mexotic.mexotic.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Tour")
public class Tour {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idTour", unique=true, nullable=false)
    private Long idTour;
	
	@Column(name="nombre", nullable=false)
    private String nombre;
	
	@Column(name="estado", nullable=false)
	@Enumerated(EnumType.STRING)
    private Estado estado;
	
	@Column(name="ciudad", nullable=false)
    private String ciudad;
	
	@Column(name="imgPortada", nullable=false)
    private String imgPortada;
	
	@Column(name="img", nullable=false)
    private String img;
	
	@Column(name="descripcion", nullable=false)
    private String descripcion;
	
	@Column(name="duracion", nullable=false)
    private String duracion;
	
	@Column(name="precio", nullable=false)
    private Double precio;
	
	@Column(name="precioExclusivo", nullable=false)
    private Double precioExclusivo;
	
	// Texto largo
	@Lob
	@Column(name="incluye", nullable=false)
	private String incluye;
	
	@Enumerated(EnumType.STRING)
	@Column(name="categoria", nullable=false)
    private Categoria categoria;
	
	@ManyToMany(mappedBy = "tours")
	private List<Usuario> usuarios;
	
	@OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<ReservaHasTour> reservas;
	
	@OneToOne(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = true)
    private InformacionTour informacionTour;

    // Constructores
    public Tour(String nombre, Estado estado, String ciudad, String imgPortada, String img, String descripcion,
            String duracion, Double precio, Double precioExclusivo, String incluye, Categoria categoria) {
        this.nombre = nombre;
        this.estado = estado;
        this.ciudad = ciudad;
        this.imgPortada = imgPortada;
        this.img = img;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.precio = precio;
        this.precioExclusivo = precioExclusivo;
        this.incluye = incluye;
        this.categoria = categoria;
//        Tour.total++;
//        this.idTour = Tour.total;
    } // Constructor
    
    public Tour() {
//        Tour.total++;
//        this.idTour = Tour.total;
    } // Constructor vacío


    // Getters and setters
    public Long getIdTour() {
        return idTour;
    } // getIdTour

    public String getNombre() {
        return nombre;
    } // getNombre

    public void setNombre(String nombre) {
        this.nombre = nombre;
    } // setNombre

    public Estado getEstado() {
        return estado;
    } // getEstado

    public void setEstado(Estado estado) {
        this.estado = estado;
    } // setEstado

    public String getCiudad() {
        return ciudad;
    } // getCiudad

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    } // setCiudad

    public String getImgPortada() {
        return imgPortada;
    } // getImgPortada

    public void setImgPortada(String imgPortada) {
        this.imgPortada = imgPortada;
    } // setImgPortada

    public String getImg() {
        return img;
    } // getImg

    public void setImg(String img) {
        this.img = img;
    } // setImg

    public String getDescripcion() {
        return descripcion;
    } // getDescripcion

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    } // setDescripcion

    public String getDuracion() {
        return duracion;
    } // getDuracion

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    } // setDuracion

    public Double getPrecio() {
        return precio;
    } // getPrecio

    public void setPrecio(Double precio) {
        this.precio = precio;
    } // setPrecio

    public Double getPrecioExclusivo() {
        return precioExclusivo;
    } // getPrecioExclusivo

    public void setPrecioExclusivo(Double precioExclusivo) {
        this.precioExclusivo = precioExclusivo;
    } // setPrecioExclusivo

    public String getIncluye() {
        return incluye;
    } // getIncluye

    public void setIncluye(String incluye) {
        this.incluye = incluye;
    } // setIncluye

    public Categoria getCategoria() {
        return categoria;
    } // getCategoria

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    } // setCategoria

    
    public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public List<ReservaHasTour> getReservas() {
		return reservas;
	}

	public InformacionTour getInformacionTour() {
		return informacionTour;
	}

	public void setInformacionTour(InformacionTour informacionTour) {
		this.informacionTour = informacionTour;
	}

	@Override
    public String toString() {
        return "Tour [idTour=" + idTour + ", nombre=" + nombre + ", estado=" + estado + ", ciudad=" + ciudad
                + ", imgPortada=" + imgPortada + ", img=" + img + ", descripcion=" + descripcion + ", duracion="
                + duracion + ", precio=" + precio + ", precioExclusivo=" + precioExclusivo + ", incluye=" + incluye
                + ", categoria=" + categoria + "]";
    } // toString

} // class Tour

