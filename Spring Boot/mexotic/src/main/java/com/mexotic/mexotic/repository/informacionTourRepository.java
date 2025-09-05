package com.mexotic.mexotic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mexotic.mexotic.model.informacionTour;

@Repository
public interface informacionTourRepository extends JpaRepository<informacionTour, Long>{
	Optional<informacionTour>findById(Long idInformacionTour);
}//Interface Informacion Tour Repository
