package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.models.EntornoAprendizajeCurricular;
import com.capacitaciones.continuas.repositorys.EntornoAprendizajeCurricularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EntornoAprendizajeCurricularServiceImpl extends GenericServiceImpl<EntornoAprendizajeCurricular, Integer> implements EntornoAprendizajeCurricularService {
    @Autowired
    private EntornoAprendizajeCurricularRepository entornoAprendizajeCurricularRepository;
    @Override
    public CrudRepository<EntornoAprendizajeCurricular, Integer> getDao() {
        return entornoAprendizajeCurricularRepository;
    }
}
