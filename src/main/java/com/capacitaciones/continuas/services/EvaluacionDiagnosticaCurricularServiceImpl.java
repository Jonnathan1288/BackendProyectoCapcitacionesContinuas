package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.EvaluacionDiagnosticaCurricular;
import com.capacitaciones.continuas.repositorys.Primarys.EvaluacionDiagnosticoCurricularRepository;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImpl;
import com.capacitaciones.continuas.services.generic.GenericServiceImplv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluacionDiagnosticaCurricularServiceImpl extends GenericServiceImplv2<EvaluacionDiagnosticaCurricular, Integer> implements EvaluacionDiacnosticaCurricularService {
    @Autowired
    private EvaluacionDiagnosticoCurricularRepository evaluacionDiagnosticoCurricularRepository;
    @Override
    public GenericRepository<EvaluacionDiagnosticaCurricular, Integer> getDao() {
        return evaluacionDiagnosticoCurricularRepository;
    }

    @Override
    public List<EvaluacionDiagnosticaCurricular> findByDisenioCurricularIdDisenioCurricular(Integer idCDisenioCurricular) {
        return evaluacionDiagnosticoCurricularRepository.findByDisenioCurricularIdDisenioCurricular(idCDisenioCurricular);
    }
}
