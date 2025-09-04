package com.mexotic.mexotic.model;

public class Tour {
    
    private Long idTour;
    private String nombre;
    private Estado estado;
    private String ciudad;
    private String imgPortada;
    private String img;
    private String descripcion;
    private String duracion;
    private Double precio;
    private Double precioExclusivo;
	// Texto largo
    private String incluye;
    private Categoria categoria;

    // Para id Auto increment
    private static long total = 0;

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
        Tour.total++;
        this.idTour = Tour.total;
    } // Constructor
    
    public Tour() {
        Tour.total++;
        this.idTour = Tour.total;
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

    public static long getTotal() {
        return total;
    } // getTotal

    public static void setTotal(long total) {
        Tour.total = total;
    } // setTotal

    @Override
    public String toString() {
        return "Tour [idTour=" + idTour + ", nombre=" + nombre + ", estado=" + estado + ", ciudad=" + ciudad
                + ", imgPortada=" + imgPortada + ", img=" + img + ", descripcion=" + descripcion + ", duracion="
                + duracion + ", precio=" + precio + ", precioExclusivo=" + precioExclusivo + ", incluye=" + incluye
                + ", categoria=" + categoria + "]";
    } // toString

} // class Tour

