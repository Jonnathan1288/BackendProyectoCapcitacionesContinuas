package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.models.NecesidadCurso;
import com.capacitaciones.continuas.repositorys.NecesidadCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class NecesidadCursoServiceImpl extends GenericServiceImpl<NecesidadCurso, Integer> implements NecesidadCursoService {

    @Autowired
    NecesidadCursoRepository necesidadCursoRepository;

    @Override
    public CrudRepository<NecesidadCurso, Integer> getDao() {
        return necesidadCursoRepository;
    }
}