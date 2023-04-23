package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.models.EvalucionFormativaCurricular;
import com.capacitaciones.continuas.models.FichaMatricula;
import com.capacitaciones.continuas.repositorys.EvaluacionFormativaCurricularRepository;
import com.capacitaciones.continuas.repositorys.FichaMatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class FichaMatriculaServiceImpl extends GenericServiceImpl<FichaMatricula, Integer> implements FichaMatriculaService {
    @Autowired
    private FichaMatriculaRepository fichaMatriculaRepository;
    @Override
    public CrudRepository<FichaMatricula, Integer> getDao() {
        return fichaMatriculaRepository;
    }
}
