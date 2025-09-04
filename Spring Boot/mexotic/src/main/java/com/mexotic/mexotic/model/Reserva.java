<<<<<<< HEAD:Spring Boot/mexotic/src/main/java/com/mexotic/mexotic/reserva/model/Reserva.java
package com.mexotic.mexotic.reserva.model;

public class Reserva {
    private Long id;
    private String fechaReserva;
    private String estado;
    private Long usuarioId;
=======
package com.mexotic.mexotic.model;
>>>>>>> ad0d5f17abd0049a99810c351bce4bea8f0a0519:Spring Boot/mexotic/src/main/java/com/mexotic/mexotic/model/Reserva.java

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