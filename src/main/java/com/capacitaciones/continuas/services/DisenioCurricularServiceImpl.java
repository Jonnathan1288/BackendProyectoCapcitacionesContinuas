package com.capacitaciones.continuas.services;

import models.DisenioCurricular;
import com.capacitaciones.continuas.repositorys.DisenioCurricularRepository;
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
