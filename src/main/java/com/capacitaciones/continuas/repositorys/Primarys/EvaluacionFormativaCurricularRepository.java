package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.EvalucionFormativaCurricular;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluacionFormativaCurricularRepository extends GenericRepository<EvalucionFormativaCurricular, Integer> {
    List<EvalucionFormativaCurricular> findByDisenioCurricularIdDisenioCurricular(Integer idCDisenioCurricular);
}

