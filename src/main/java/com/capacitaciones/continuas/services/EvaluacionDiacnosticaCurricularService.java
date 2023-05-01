package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.models.EntornoAprendizajeCurricular;
import com.capacitaciones.continuas.models.EvaluacionDiagnosticaCurricular;

import java.util.List;

public interface EvaluacionDiacnosticaCurricularService extends  GenericService<EvaluacionDiagnosticaCurricular, Integer>{
    List<EvaluacionDiagnosticaCurricular> findByDisenioCurricularbyDisenio(Integer idDisenioCurricular);
}
