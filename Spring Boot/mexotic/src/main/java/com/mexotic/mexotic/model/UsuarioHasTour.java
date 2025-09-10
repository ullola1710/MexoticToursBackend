//package com.mexotic.mexotic.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@Entity
//@Table(name = "Usuario_has_Tour")
//public class UsuarioHasTour {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    // relación con Usuario
//    @ManyToOne
//    @JoinColumn(name = "usuario_id", nullable = false)
//    private Usuario usuario;
//
//    // relación con Tour
//    @ManyToOne
//    @JoinColumn(name = "tour_id", nullable = false)
//    private Tour tour;
//
//    // constructor personalizado
//    public UsuarioHasTour(Usuario usuario, Tour tour) {
//        this.usuario = usuario;
//        this.tour = tour;
//    }
//    
//    // Getters y Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }
//
//    public Tour getTour() {
//        return tour;
//    }
//
//    public void setTour(Tour tour) {
//        this.tour = tour;
//    }
//
//    // toString() 
//    @Override
//    public String toString() {
//        return "UsuarioHasTour{" +
//                "id=" + id +
//                ", usuario=" + usuario +
//                ", tour=" + tour +
//                '}';
//    }
//}


//package com.mexotic.mexotic.model;
//
//import javax.persistence.Column;
////import javax.persistence.Entity;
////import javax.persistence.GeneratedValue;
////import javax.persistence.GenerationType;
////import javax.persistence.Id;
////import javax.persistence.Table;
////
////
////
////@Entity
////@Table (name = "usuario_has_tour")
////public class UsuarioHasTour {
////	@Id
////	@GeneratedValue (strategy = GenerationType.IDENTITY)
////	private Long id;
////	@Column(name = "id_usuario", nullable = false)
////	private Long idUsuario;
////	@Column(name = "id_tour", nullable = false)
////	private Long idTour;
////	
//////	private static long total=0;
////    public UsuarioHasTour(Long idUsuario, Long idTour) {
////        this.idUsuario = idUsuario;
////        this.idTour = idTour;
////        
//////        UsuarioHasTour.total++;
//////        this.id = UsuarioHasTour.total;
////    }
////    
////    public UsuarioHasTour() {
//////    	UsuarioHasTour.total++;
//////        this.id = UsuarioHasTour.total;
////    }
////    
////    
////    
////	public Long getId() {
////		return id;
////	}
////
////	public void setId(Long id) {
////		this.id = id;
////	}
////
////	public Long getIdUsuario() {
////		return idUsuario;
////	}
////
////	public void setIdUsuario(Long idUsuario) {
////		this.idUsuario = idUsuario;
////	}
////
////	public Long getIdTour() {
////		return idTour;
////	}
////
////	public void setIdTour(Long idTour) {
////		this.idTour = idTour;
////	}
////
////	@Override
////	public String toString() {
////		return "UsuarioHasTour [idUsuario=" + idUsuario + ", idTour=" + idTour + "]";
////	}
////    
////    
////}
