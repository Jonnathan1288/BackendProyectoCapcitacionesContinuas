package com.capacitaciones.continuas.services;

import models.EvalucionFormativaCurricular;
import com.capacitaciones.continuas.repositorys.EvaluacionFormativaCurricularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EvaluacionFormativaCurricularServiceImpl extends GenericServiceImpl<EvalucionFormativaCurricular, Integer> implements EvaluacionFormativaCurricularService {
    @Autowired
    private EvaluacionFormativaCurricularRepository evaluacionFormativaCurricularRepository;
    @Override
    public CrudRepository<EvalucionFormativaCurricular, Integer> getDao() {
        return evaluacionFormativaCurricularRepository;
    }
}
