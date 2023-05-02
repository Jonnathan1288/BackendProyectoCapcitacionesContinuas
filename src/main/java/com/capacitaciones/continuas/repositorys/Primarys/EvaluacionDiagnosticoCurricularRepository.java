package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.EvaluacionDiagnosticaCurricular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacionDiagnosticoCurricularRepository extends JpaRepository<EvaluacionDiagnosticaCurricular, Integer> {
}

