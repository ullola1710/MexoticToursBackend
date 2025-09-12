package com.mexotic.mexotic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mexotic.mexotic.model.Pago;
import com.mexotic.mexotic.repository.PagoRepository;

@Service
public class PagoService {
	
    private final PagoRepository pagoRepository;

    @Autowired
    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    // Obtener todos los pagos
    @Transactional(readOnly = true)
    public List<Pago> getPagos() {
        return pagoRepository.findAll();
    }

    // Obtener un pago por ID
    @Transactional(readOnly = true)
    public Pago getPago(Long idPago) {
        return pagoRepository.findById(idPago)
                .orElseThrow(() -> new IllegalArgumentException("El pago con el id[" + idPago + "] no existe"));
    }

    // Eliminar un pago por ID
    @Transactional
    public Pago deletePago(Long idPago) {
        Pago tmpPago = null;
        if (pagoRepository.existsById(idPago)) {
            tmpPago = pagoRepository.findById(idPago).get();
            pagoRepository.deleteById(idPago);
        }
        return tmpPago;
    }

    // Agregar un pago
    @Transactional
    public Pago addPago(Pago pago) {
        if (pago.getReserva() == null || pago.getReserva().getIdReserva() == null) {
            throw new IllegalArgumentException("El pago debe estar asociado a una reserva válida.");
        }

        Optional<Pago> existingPago = pagoRepository.findByReserva(pago.getReserva());
        if (existingPago.isPresent()) {
            throw new IllegalArgumentException("Ya existe un pago para esta reserva.");
        }

        return pagoRepository.save(pago);
    }
}
