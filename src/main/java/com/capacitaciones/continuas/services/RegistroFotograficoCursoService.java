package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.models.RegistroFotograficoCurso;

import java.util.List;

public interface RegistroFotograficoCursoService extends GenericService<RegistroFotograficoCurso,Integer>{
    public List<RegistroFotograficoCurso> findByCursoIdCurso(Integer idCurso);
}
