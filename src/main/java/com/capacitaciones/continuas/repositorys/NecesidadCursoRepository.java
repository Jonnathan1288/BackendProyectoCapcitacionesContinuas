package com.capacitaciones.continuas.repositorys;

import models.NecesidadCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NecesidadCursoRepository extends JpaRepository<NecesidadCurso, Integer> {
}

