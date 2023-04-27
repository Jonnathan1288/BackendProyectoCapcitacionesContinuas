package com.capacitaciones.continuas.services;

import models.ContenidoSilabo;
import com.capacitaciones.continuas.repositorys.ContenidoSilaboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ContenidoSilaboServiceImpl extends GenericServiceImpl<ContenidoSilabo, Integer> implements ContenidoSilaboService{
    @Autowired
    private ContenidoSilaboRepository contenidoSilaboRepository;
    @Override
    public CrudRepository<ContenidoSilabo, Integer> getDao() {
        return contenidoSilaboRepository;
    }
}
