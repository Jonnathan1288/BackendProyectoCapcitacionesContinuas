package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.EvalucionFormativaCurricular;
import com.capacitaciones.continuas.repositorys.Primarys.EvaluacionFormativaCurricularRepository;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImpl;
import com.capacitaciones.continuas.services.generic.GenericServiceImplv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluacionFormativaCurricularServiceImpl extends GenericServiceImplv2<EvalucionFormativaCurricular, Integer> implements EvaluacionFormativaCurricularService {
    @Autowired
    private EvaluacionFormativaCurricularRepository evaluacionFormativaCurricularRepository;
    @Override
    public GenericRepository<EvalucionFormativaCurricular, Integer> getDao() {
        return evaluacionFormativaCurricularRepository;
    }

    @Override
    public List<EvalucionFormativaCurricular> findByDisenioCurricularIdDisenioCurricular(Integer idDisenioCurricular) {
        return evaluacionFormativaCurricularRepository.findByDisenioCurricularIdDisenioCurricular(idDisenioCurricular);
    }
}
