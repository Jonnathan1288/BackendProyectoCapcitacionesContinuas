package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.MecanismosEvaluacionCurricular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MecanismoEvalucionCurricularRespository extends JpaRepository<MecanismosEvaluacionCurricular, Integer> {
}

