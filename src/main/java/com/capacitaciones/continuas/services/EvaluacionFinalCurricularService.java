package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.EvaluacionFinalCurricular;
import com.capacitaciones.continuas.services.generic.GenericService;

import java.util.List;

public interface EvaluacionFinalCurricularService extends GenericService<EvaluacionFinalCurricular, Integer> {
    List<EvaluacionFinalCurricular> findByDisenioCurricularIdDisenioCurricular(Integer idCDisenioCurricular);
}
