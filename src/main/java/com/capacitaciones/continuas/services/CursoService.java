package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.interfaces.CoursesFilter;
import com.capacitaciones.continuas.Modelos.Primary.Curso;
import com.capacitaciones.continuas.interfaces.CoursesFilterByDocente;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CursoService extends GenericService<Curso, Integer> {
    public List<Curso> findByCapacitadorIdCapacitador(Integer idCapacitador);

    public List<Curso> findByEstadoCursoAndEstadoPublicasionCurso(boolean estadoCurso);

    public List<Curso> findCursosDelParticipante(Integer idParticipante);


    //NEW METHODS
    public List<CoursesFilter> findFilterCoursesD();

    public List<CoursesFilterByDocente> findFilterCoursesByUsuarioDocente(Integer idUser);

    public List<CoursesFilterByDocente> findByIdUsuarioEstadoCursoFinalizado(Integer idUser);


}
