package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.models.NivelCurso;
import com.capacitaciones.continuas.repositorys.NivelCursoRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class NivelCursoServiceImpl extends GenericServiceImpl<NivelCurso, Integer> implements NivelCursoService {

    @Autowired
    private NivelCursoRepositry nivelCursoRepositry;

    @Override
    public CrudRepository<NivelCurso, Integer> getDao() {
        return nivelCursoRepositry;
    }
}