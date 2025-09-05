package com.mexotic.mexotic.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mexotic.mexotic.model.Experiencia;

@Repository
public interface ExperienciasRepository extends JpaRepository<Experiencia, Long>{
	Optional<Experiencia> findById (Long Id);
}//interface ExperienciasRepository
