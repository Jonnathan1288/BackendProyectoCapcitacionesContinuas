package com.capacitaciones.continuas.services;

import models.Programas;
import com.capacitaciones.continuas.repositorys.ProgramasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProgramaServiceImpl extends GenericServiceImpl<Programas, Integer> implements ProgramaService {

    @Autowired
    ProgramasRepository programasRepository;

    @Override
    public CrudRepository<Programas, Integer> getDao() {
        return programasRepository;
    }
}
