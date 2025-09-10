package com.mexotic.mexotic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mexotic.mexotic.model.Tour;
import com.mexotic.mexotic.model.InformacionTour;

@Repository
public interface informacionTourRepository extends JpaRepository<InformacionTour, Long>{
	Optional<InformacionTour>findByTour(Tour idTour);
}//Interface Informacion Tour Repository
