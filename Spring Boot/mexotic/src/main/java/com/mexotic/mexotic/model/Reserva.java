package com.mexotic.mexotic.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

    
    @ManyToOne 
    @JoinColumn(name = "fk_idUsuario", referencedColumnName = "idUsuario")
    @JsonBackReference 
    private Usuario fkIdUsuario;
   
    @OneToOne(mappedBy = "reserva", cascade = CascadeType.ALL)
    private Pago pago;

    public Reserva() {} // Constructor vacío para JPA

    public Reserva(Integer cantidad, Usuario fkIdUsuario) {
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

    public Usuario getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(Usuario fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }
    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "Reserva{idReserva=" + idReserva + ", cantidad=" + cantidad + ", fkIdUsuario=" + fkIdUsuario + "}";
    }
}
