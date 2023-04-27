package com.capacitaciones.continuas.services;


import models.PrerequisitoCurso;
import com.capacitaciones.continuas.repositorys.PrerequisitoCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PrerequisitoServiceImpl extends GenericServiceImpl<PrerequisitoCurso, Integer> implements PrerequisitoCursoService {

    @Autowired
    private PrerequisitoCursoRepository prerequisitoCursoRepository;

    @Override
    public CrudRepository<PrerequisitoCurso, Integer> getDao() {
        return prerequisitoCursoRepository;
    }
}
