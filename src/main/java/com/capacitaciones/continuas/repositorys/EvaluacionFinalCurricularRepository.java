package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.EvaluacionDiagnosticaCurricular;
import com.capacitaciones.continuas.models.EvaluacionFinalCurricular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluacionFinalCurricularRepository extends JpaRepository<EvaluacionFinalCurricular, Integer> {
    List<EvaluacionFinalCurricular> findByDisenioCurricularbyDisenio(Integer idDisenioCurricular);
}
