package com.mexotic.mexotic.reserva.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "fk_idPago", nullable = false)
    private Pago pago;

    @ManyToOne
    @JoinColumn(name = "fk_idUsuario", nullable = false)
    private Usuario usuario;

    // Getters & Setters
    public Integer getIdReserva() { return idReserva; }
    public void setIdReserva(Integer idReserva) { this.idReserva = idReserva; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    public Pago getPago() { return pago; }
    public void setPago(Pago pago) { this.pago = pago; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}