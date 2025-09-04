package com.mexotic.mexotic.reserva.model;

public class Reserva {
    private Long id;
    private String fechaReserva;
    private String estado;
    private Long usuarioId;

    //Constructores
    public Reserva() {}

    public Reserva(Long id, String fechaReserva, String estado, Long usuarioId) {
        this.id = id;
        this.fechaReserva = fechaReserva;
        this.estado = estado;
        this.usuarioId = usuarioId;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(String fechaReserva) { this.fechaReserva = fechaReserva; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}