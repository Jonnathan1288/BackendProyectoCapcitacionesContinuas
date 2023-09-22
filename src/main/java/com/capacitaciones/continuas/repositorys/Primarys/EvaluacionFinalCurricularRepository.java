package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.EvaluacionFinalCurricular;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluacionFinalCurricularRepository extends GenericRepository<EvaluacionFinalCurricular, Integer> {
    List<EvaluacionFinalCurricular> findByDisenioCurricularIdDisenioCurricular(Integer idCDisenioCurricular);
}
