package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.DisenioCurricular;
import com.capacitaciones.continuas.repositorys.Primarys.DisenioCurricularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DisenioCurricularServiceImpl extends GenericServiceImpl<DisenioCurricular, Integer> implements DisenioCurricularService{
    @Autowired
    private DisenioCurricularRepository disenioCurricularRepository;
    @Override
    public CrudRepository<DisenioCurricular, Integer> getDao() {
        return disenioCurricularRepository;
    }
}
