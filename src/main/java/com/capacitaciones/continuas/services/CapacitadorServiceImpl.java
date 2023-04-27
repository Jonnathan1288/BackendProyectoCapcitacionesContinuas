package com.capacitaciones.continuas.services;

import models.Capacitador;
import com.capacitaciones.continuas.repositorys.CapacitadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CapacitadorServiceImpl extends GenericServiceImpl<Capacitador, Integer> implements CapacitadorService{
    @Autowired
    private CapacitadorRepository capacitadorRepository;
    @Override
    public CrudRepository<Capacitador, Integer> getDao() {
        return capacitadorRepository;
    }
}
