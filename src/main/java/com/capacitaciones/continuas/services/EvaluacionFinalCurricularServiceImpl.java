package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.models.EvaluacionDiagnosticaCurricular;
import com.capacitaciones.continuas.models.EvaluacionFinalCurricular;
import com.capacitaciones.continuas.repositorys.EvaluacionDiagnosticoCurricularRepository;
import com.capacitaciones.continuas.repositorys.EvaluacionFinalCurricularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EvaluacionFinalCurricularServiceImpl extends GenericServiceImpl<EvaluacionFinalCurricular, Integer> implements EvaluacionFinalCurricularService {
    @Autowired
    private EvaluacionFinalCurricularRepository evaluacionFinalCurricularRepository;
    @Override
    public CrudRepository<EvaluacionFinalCurricular, Integer> getDao() {
        return evaluacionFinalCurricularRepository;
    }
}
