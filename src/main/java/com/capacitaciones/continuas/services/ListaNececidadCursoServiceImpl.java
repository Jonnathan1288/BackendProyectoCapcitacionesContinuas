package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.models.ListaNecesidadCurso;
import com.capacitaciones.continuas.repositorys.ListaNecesidadCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ListaNececidadCursoServiceImpl extends GenericServiceImpl<ListaNecesidadCurso, Integer> implements ListaNecesidadCursoService {

    @Autowired
    private ListaNecesidadCursoRepository listaNecesidadCursoRepository;

    @Override
    public CrudRepository<ListaNecesidadCurso, Integer> getDao() {
        return listaNecesidadCursoRepository;
    }

}
