package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.models.Curso;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CursoService extends  GenericService<Curso, Integer>{
    public List<Curso> findByCapacitadorIdCapacitador(Integer idCapacitador);

    public List<Curso> findByEstadoCursoAndEstadoPublicasionCurso(boolean estadoCurso);

    public List<Curso> findCursosDelParticipante(Integer idParticipante);


}
