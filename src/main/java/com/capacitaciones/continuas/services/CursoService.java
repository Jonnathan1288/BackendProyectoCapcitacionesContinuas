package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.models.Curso;

import java.util.List;

public interface CursoService extends  GenericService<Curso, Integer>{
    public List<Curso> findByCapacitadorIdCapacitador(Integer idCapacitador);

}
