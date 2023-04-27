package com.capacitaciones.continuas.services;

import models.EvaluacionDiagnosticaCurricular;
import com.capacitaciones.continuas.repositorys.EvaluacionDiagnosticoCurricularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EvaluacionDiagnosticaCurricularServiceImpl extends GenericServiceImpl<EvaluacionDiagnosticaCurricular, Integer> implements EvaluacionDiacnosticaCurricularService {
    @Autowired
    private EvaluacionDiagnosticoCurricularRepository evaluacionDiagnosticoCurricularRepository;
    @Override
    public CrudRepository<EvaluacionDiagnosticaCurricular, Integer> getDao() {
        return evaluacionDiagnosticoCurricularRepository;
    }
}
