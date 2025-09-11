package com.mexotic.mexotic.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mexotic.mexotic.model.Experiencia;

@Repository
public interface ExperienciasRepository extends JpaRepository<Experiencia, Long> {

	Optional<Experiencia> findByComentario(String comentario);

	@EntityGraph(attributePaths = {"tour", "usuario"})
    Page<Experiencia> findAll(Pageable pageable);

    @EntityGraph(attributePaths = {"tour", "usuario"})
    Page<Experiencia> findByTour_IdTour(Long idTour, Pageable pageable);

}// interface ExperienciasRepository
