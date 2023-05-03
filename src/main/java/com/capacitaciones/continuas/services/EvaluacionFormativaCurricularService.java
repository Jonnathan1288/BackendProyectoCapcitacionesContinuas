package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.models.EvaluacionFinalCurricular;
import com.capacitaciones.continuas.models.EvalucionFormativaCurricular;

import java.util.List;

public interface EvaluacionFormativaCurricularService extends  GenericService<EvalucionFormativaCurricular, Integer>{

    List<EvalucionFormativaCurricular> findByDisenioCurricularIdDisenioCurricular(Integer idDisenioCurricular);
}
