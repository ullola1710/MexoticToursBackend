package com.mexotic.mexotic.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reserva")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReserva", updatable = false, nullable = false)
    private Long idReserva;

    @Column(nullable = false)
    private Integer cantidad;

    // FK temporal como Long (después lo cambias a @ManyToOne con Usuario)
    @Column(name = "fk_idUsuario", nullable = false)
    private Long fkIdUsuario;

    public Reserva() {} // Constructor vacío para JPA

    public Reserva(Integer cantidad, Long fkIdUsuario) {
        this.cantidad = cantidad;
        this.fkIdUsuario = fkIdUsuario;
    }

    // Getters y Setters
    public Long getIdReserva() {
        return idReserva;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Long getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(Long fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    @Override
    public String toString() {
        return "Reserva{idReserva=" + idReserva + ", cantidad=" + cantidad + ", fkIdUsuario=" + fkIdUsuario + "}";
    }
}
