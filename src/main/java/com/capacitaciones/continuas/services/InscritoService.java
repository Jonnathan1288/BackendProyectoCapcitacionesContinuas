package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.models.Inscrito;

import java.util.List;

public interface InscritoService extends GenericService<Inscrito, Integer>{
    List<Inscrito> findByCursoIdCurso(Integer idCurso);
}
