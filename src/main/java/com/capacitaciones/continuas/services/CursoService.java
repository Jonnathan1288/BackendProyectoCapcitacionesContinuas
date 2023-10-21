package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.interfaces.CoursesFilter;
import com.capacitaciones.continuas.Modelos.Primary.Curso;
import com.capacitaciones.continuas.interfaces.CoursesFilterByDocente;
import com.capacitaciones.continuas.interfaces.ListCourseReduce;
import com.capacitaciones.continuas.payload.PayloadCurso;
import com.capacitaciones.continuas.payload.PayloadEncabezadoNotasFinales;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface CursoService extends GenericService<Curso, Integer> {
    public List<Curso> findByCapacitadorIdCapacitador(Integer idCapacitador);

    public List<Curso> findByEstadoCursoAndEstadoPublicasionCurso(boolean estadoCurso);

    public List<Curso> findCursosDelParticipante(Integer idParticipante);
    public PayloadEncabezadoNotasFinales getEncabezadoNotasFinales(Integer idCurso);

    //NEW METHODS
    public List<CoursesFilter> findFilterCoursesD();

    public List<CoursesFilterByDocente> findFilterCoursesByUsuarioDocente(Integer idUser);

    public List<CoursesFilterByDocente> findByIdUsuarioEstadoCursoFinalizado(Integer idUser);

    public Page<Curso> findByCapacitadorUsuarioIdUsuarioPageable(Integer idCapacitador, Pageable pageable);


    public Integer updateStatusCourseAcepted(Integer idCurso, String status);

    public List<Curso> findByAllC();
    public CompletableFuture<List<Curso>> findByAllAsync();

    public Page<ListCourseReduce> findByAllCourseDataReducePageable(Pageable pageable);

    Page<PayloadCurso> findByEstadoCursoPublicado(Pageable pageable);

    public Integer updateCourseStatus(Integer idCurso, String status);

}
