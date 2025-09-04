package com.mexotic.mexotic.pago.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mexotic.mexotic.pago.model.Pago;

@Service
public class PagoService {
		private final ArrayList<Pago> lista = new ArrayList<Pago>();
		@Autowired
		public PagoService() {
			//Double monto, Date fechaPago, String metodoPago
			lista.add(new Pago(350.5, new Date(), "Tarjeta de Crédito"));
			lista.add(new Pago(255.50, new Date(), "Transferencia"));
			lista.add(new Pago(2000.5, new Date(), "Comisionista"));
			lista.add(new Pago(650.5, new Date(), "Tarjeta de Crédito"));
			lista.add(new Pago(1800.5, new Date(), "Comisionista"));
			lista.add(new Pago(395.50, new Date(), "Transferencia"));
			lista.add(new Pago(950.75, new Date(), "Tarjeta de Crédito"));
		}//Constructor 
		
		public List<Pago> getPagos(){
			return lista; 
		}//GetPagos

		public Pago getPago(Long idPago) {
			Pago tmpPago = null;
			for (Pago pag : lista) {
				if(pag.getIdPago()==idPago) {
					tmpPago=pag;
					break;
				}//if
			}//foreach
			return tmpPago;
		}//getPago

		
		
		
		public Pago deletePago(Long idPago) {
			Pago tmpPago = null;
			for (Pago pag : lista) {
				if(pag.getIdPago()==idPago) {
					tmpPago=pag;
					lista.remove(pag);
					break;
				}//if
			}//foreach
			return tmpPago;
		}//Delete pago
		
	
		public Pago addPago(Pago pago) {
			lista.add(pago);
			return pago; 
			}//addPagos

		public Pago updatePago(Long idPago, Double monto, Date fechaPago, String metodoPago) { {
				Pago tmpPago = null;
				for (Pago pag : lista) {
					if(pag.getIdPago()==idPago) {
						if(monto!=null) pag.setMonto(monto);
						if(fechaPago!=null) pag.setFechaPago(fechaPago);
						if(metodoPago!=null) pag.setMetodoPago(metodoPago);
						tmpPago=pag;
						break;
					}//if
				}//foreach
				return tmpPago;
			}//PutPago
		} //updatePago

		
		
		
}//class PagoService 
