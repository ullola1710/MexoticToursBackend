package com.mexotic.mexotic.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Reserva") // ajusta a "reserva" si tu tabla está en minúsculas
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReserva", updatable = false, nullable = false)
    private Long idReserva;

    @Column(nullable = false)
    private Integer cantidad;


    @Column(name = "fk_idUsuario", nullable = false)
    private Long fkIdUsuario;

    public Reserva() {}

    public Reserva(Integer cantidad, Long fkIdUsuario) {
        this.cantidad = cantidad;
        this.fkIdUsuario = fkIdUsuario;
    }//Contructor

    public Long getIdReserva() {
        return idReserva;
    }//getIdReserva
    public Integer getCantidad() {
        return cantidad;
    }//getCantidad
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }//setCantidad
    public Long getFkIdUsuario() {
        return fkIdUsuario;
    }//getFKidUsuario
    public void setFkIdUsuario(Long fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }//setfkidUsuario
    
    @Override
    public String toString() {
        return "Reserva{idReserva=" + idReserva +
               ", cantidad=" + cantidad +
               ", fkIdUsuario=" + fkIdUsuario + "}";
    }
}
