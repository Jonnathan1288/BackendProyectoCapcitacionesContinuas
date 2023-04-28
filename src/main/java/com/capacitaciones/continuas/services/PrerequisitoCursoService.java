package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.models.PrerequisitoCurso;

import java.util.List;

public interface PrerequisitoCursoService extends  GenericService<PrerequisitoCurso, Integer>{

    List<PrerequisitoCurso> findByCursoIdCurso(Integer idCurso);

}
