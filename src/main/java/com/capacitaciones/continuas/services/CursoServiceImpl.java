package com.capacitaciones.continuas.services;

import models.Curso;
import com.capacitaciones.continuas.repositorys.CursoRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl extends GenericServiceImpl<Curso, Integer> implements CursoService{
    @Autowired
    private CursoRepositry cursoRepositry;
    @Override
    public CrudRepository<Curso, Integer> getDao() {
        return cursoRepositry;
    }
}
