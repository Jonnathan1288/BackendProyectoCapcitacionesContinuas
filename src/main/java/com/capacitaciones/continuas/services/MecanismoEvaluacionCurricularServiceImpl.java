package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.models.MecanismosEvaluacionCurricular;
import com.capacitaciones.continuas.repositorys.MecanismoEvalucionCurricularRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class MecanismoEvaluacionCurricularServiceImpl extends GenericServiceImpl<MecanismosEvaluacionCurricular, Integer> implements MecanismoEvaluacionCurricularService {

    @Autowired
    MecanismoEvalucionCurricularRespository mecanismoEvalucionCurricularRespository;

    @Override
    public CrudRepository<MecanismosEvaluacionCurricular, Integer> getDao() {
        return mecanismoEvalucionCurricularRespository;
    }

}
