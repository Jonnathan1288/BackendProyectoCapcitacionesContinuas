package com.capacitaciones.continuas.repositorys;

import models.EvaluacionFinalCurricular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacionFinalCurricularRepository extends JpaRepository<EvaluacionFinalCurricular, Integer> {
}
