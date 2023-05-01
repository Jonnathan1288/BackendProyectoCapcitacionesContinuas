package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.models.EvaluacionDiagnosticaCurricular;
import com.capacitaciones.continuas.models.EvaluacionFinalCurricular;

import java.util.List;

public interface EvaluacionFinalCurricularService extends  GenericService<EvaluacionFinalCurricular, Integer>{
    List<EvaluacionFinalCurricular> findByDisenioCurricularIdDisenioCurricular(Integer idCDisenioCurricular);
}
