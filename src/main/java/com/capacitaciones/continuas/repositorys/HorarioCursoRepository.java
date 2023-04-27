package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.HorarioCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioCursoRepository extends JpaRepository<HorarioCurso, Integer> {
}

