package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.EvaluacionDiagnosticaCurricular;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluacionDiagnosticoCurricularRepository extends GenericRepository<EvaluacionDiagnosticaCurricular, Integer> {
    List<EvaluacionDiagnosticaCurricular> findByDisenioCurricularIdDisenioCurricular(Integer idCDisenioCurricular);
}

