package com.capacitaciones.continuas.repositorys;

import models.HorarioCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioCursoRepository extends JpaRepository<HorarioCurso, Integer> {
}

