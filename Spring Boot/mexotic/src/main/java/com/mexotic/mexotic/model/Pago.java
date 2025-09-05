package com.mexotic.mexotic.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="pago")
public class Pago {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
		private Long idPago;
	@Column(nullable=false)
		private Double monto; 
	@Column(nullable=false)
		private Date fechaPago; 
	@Column(nullable=false)
		private String metodoPago;
		
		private static long total=0;
		//Constructor
		public Pago(Double monto, Date fechaPago, String metodoPago) {
			super();
			this.monto = monto;
			this.fechaPago = fechaPago;
			this.metodoPago = metodoPago;
			//Pago.total++;
			//this.idPago=Pago.total; 	
		}//Constructor 
		
		
		public Pago() {
			
		}//constructor vacio para crear nuevos pagos desde un post 




		//Getters And Setters 
		public Long getIdPago() {
			return idPago;
		}
		public Double getMonto() {
			return monto;
		}
		public void setMonto(Double monto) {
			this.monto = monto;
		}
		public Date getFechaPago() {
			return fechaPago;
		}
		public void setFechaPago(Date fechaPago) {
			this.fechaPago = fechaPago;
		}
		public String getMetodoPago() {
			return metodoPago;
		}
		public void setMetodoPago(String metodoPago) {
			this.metodoPago = metodoPago;
		}//GettersAndSetters
		
		
		//toString
		@Override
		public String toString() {
			return "Pago [idPago=" + idPago + ", monto=" + monto + ", fechaPago=" + fechaPago + ", metodoPago=" + metodoPago
					+ "]";
		}//toString 
		
		 
		
		
	}

