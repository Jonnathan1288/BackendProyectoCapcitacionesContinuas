package com.capacitaciones.continuas.services;

import models.EstrategiasMetodologica;
import com.capacitaciones.continuas.repositorys.EstrategiaMetodologicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EstrategiaMetodologicaServiceImpl extends GenericServiceImpl<EstrategiasMetodologica, Integer> implements EstrategiaMetodologicaService {
    @Autowired
    private EstrategiaMetodologicaRepository estrategiaMetodologicaRepository;
    @Override
    public CrudRepository<EstrategiasMetodologica, Integer> getDao() {
        return estrategiaMetodologicaRepository;
    }
}
