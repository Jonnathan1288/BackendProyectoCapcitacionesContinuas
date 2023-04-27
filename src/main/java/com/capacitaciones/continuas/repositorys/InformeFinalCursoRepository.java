package com.capacitaciones.continuas.repositorys;

import models.InformeFinalCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformeFinalCursoRepository extends JpaRepository<InformeFinalCurso, Integer> {
}

