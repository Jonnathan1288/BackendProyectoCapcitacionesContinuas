package com.capacitaciones.continuas.services;


import models.InformeFinalCurso;
import com.capacitaciones.continuas.repositorys.InformeFinalCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class InformeFinalCursoServiceImpl extends GenericServiceImpl<InformeFinalCurso, Integer> implements InformeFinalCursoService {

    @Autowired
    InformeFinalCursoRepository informeFinalCursoRepository;

    @Override
    public CrudRepository<InformeFinalCurso, Integer> getDao() {
        return informeFinalCursoRepository;
    }

}

