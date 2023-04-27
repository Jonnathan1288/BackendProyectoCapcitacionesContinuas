package com.capacitaciones.continuas.services;


import models.ResultadoAprendizajeSilabo;
import com.capacitaciones.continuas.repositorys.ResultadosAprendizajeSilaboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ResultadoAprendizajeSilaboServiceImpl extends GenericServiceImpl<ResultadoAprendizajeSilabo, Integer> implements ResultadoAprendizajeSilaboService {

    @Autowired
    ResultadosAprendizajeSilaboRepository resultadosAprendizajeSilaboRepository;

    @Override
    public CrudRepository<ResultadoAprendizajeSilabo, Integer> getDao() {
        return resultadosAprendizajeSilaboRepository;
    }
}
