package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.interfaces.CoursesFilter;
import com.capacitaciones.continuas.Modelos.Primary.Curso;
import com.capacitaciones.continuas.services.generic.GenericService;

import java.util.List;

public interface CursoService extends GenericService<Curso, Integer> {
    public List<Curso> findByCapacitadorIdCapacitador(Integer idCapacitador);

    public List<Curso> findByEstadoCursoAndEstadoPublicasionCurso(boolean estadoCurso);

    public List<Curso> findCursosDelParticipante(Integer idParticipante);


    //NEW METHODS
    List<CoursesFilter> findFilterCoursesD();


}
