package com.capacitaciones.continuas.repositorys;

import models.EvalucionFormativaCurricular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacionFormativaCurricularRepository extends JpaRepository<EvalucionFormativaCurricular, Integer> {
}

