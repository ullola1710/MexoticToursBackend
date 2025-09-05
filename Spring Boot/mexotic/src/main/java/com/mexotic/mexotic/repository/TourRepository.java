package com.mexotic.mexotic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mexotic.mexotic.model.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long>{
	Optional<Tour> findByNombre(String nombre);
} // interface TourRepository