package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.RegistroFotograficoCurso;
import com.capacitaciones.continuas.services.generic.GenericService;

import java.util.List;

public interface RegistroFotograficoCursoService extends GenericService<RegistroFotograficoCurso,Integer> {
    public List<RegistroFotograficoCurso> findByCursoIdCurso(Integer idCurso);
}
