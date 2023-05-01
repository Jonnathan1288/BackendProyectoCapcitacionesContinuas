package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.EntornoAprendizajeCurricular;
import com.capacitaciones.continuas.models.EvaluacionDiagnosticaCurricular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluacionDiagnosticoCurricularRepository extends JpaRepository<EvaluacionDiagnosticaCurricular, Integer> {
    List<EvaluacionDiagnosticaCurricular> findByDisenioCurricularbyDisenio(Integer idDisenioCurricular);
}

