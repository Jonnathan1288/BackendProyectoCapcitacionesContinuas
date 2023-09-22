package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.ListaNecesidadCurso;
import com.capacitaciones.continuas.repositorys.Primarys.ListaNecesidadCursoRepository;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImpl;
import com.capacitaciones.continuas.services.generic.GenericServiceImplv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaNececidadCursoServiceImpl extends GenericServiceImplv2<ListaNecesidadCurso, Integer> implements ListaNecesidadCursoService {

    @Autowired
    private ListaNecesidadCursoRepository listaNecesidadCursoRepository;

    @Override
    public GenericRepository<ListaNecesidadCurso, Integer> getDao() {
        return listaNecesidadCursoRepository;
    }

    @Override
    public List<ListaNecesidadCurso> findByNecesidadCurso_IdNecesidadCurso(Integer idNecesidad) {
        return listaNecesidadCursoRepository.findByNecesidadCurso_IdNecesidadCurso(idNecesidad);
    }
}
