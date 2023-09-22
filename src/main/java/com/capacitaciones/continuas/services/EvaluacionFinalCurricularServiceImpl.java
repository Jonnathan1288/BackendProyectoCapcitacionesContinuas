package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.EvaluacionFinalCurricular;
import com.capacitaciones.continuas.repositorys.Primarys.EvaluacionFinalCurricularRepository;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImpl;
import com.capacitaciones.continuas.services.generic.GenericServiceImplv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluacionFinalCurricularServiceImpl extends GenericServiceImplv2<EvaluacionFinalCurricular, Integer> implements EvaluacionFinalCurricularService {
    @Autowired
    private EvaluacionFinalCurricularRepository evaluacionFinalCurricularRepository;
    @Override
    public GenericRepository<EvaluacionFinalCurricular, Integer> getDao() {
        return evaluacionFinalCurricularRepository;
    }

    @Override
    public List<EvaluacionFinalCurricular> findByDisenioCurricularIdDisenioCurricular(Integer idCDisenioCurricular) {
        return evaluacionFinalCurricularRepository.findByDisenioCurricularIdDisenioCurricular(idCDisenioCurricular);
    }
}
