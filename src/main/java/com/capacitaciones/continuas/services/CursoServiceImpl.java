package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.interfaces.CoursesFilter;
import com.capacitaciones.continuas.Modelos.Primary.Curso;
import com.capacitaciones.continuas.interfaces.CoursesFilterByDocente;
import com.capacitaciones.continuas.interfaces.ListCourseReduce;
import com.capacitaciones.continuas.repositorys.Primarys.CursoRepositry;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImplv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CursoServiceImpl extends GenericServiceImplv2<Curso, Integer> implements CursoService{

    private CursoRepositry cursoRepositry;

    @Autowired
    public CursoServiceImpl(CursoRepositry cursoRepositry){
        this.cursoRepositry = cursoRepositry;
    }
    @Override
    public GenericRepository<Curso, Integer> getDao() {
        return cursoRepositry;
    }

    @Override
    public List<Curso> findByCapacitadorIdCapacitador(Integer idCapacitador) {
        return cursoRepositry.findByCapacitadorUsuarioIdUsuario(idCapacitador);
    }

    @Override
    public List<Curso> findByEstadoCursoAndEstadoPublicasionCurso(boolean estadoCurso) {
        return cursoRepositry.findByEstadoCursoAndEstadoPublicasionCurso(estadoCurso,"V");
    }

    @Override
    public List<Curso> findCursosDelParticipante(Integer idParticipante) {
        return cursoRepositry.findCursosDelParticipante(idParticipante);
    }

    @Override
    public List<CoursesFilter> findFilterCoursesD() {
        return cursoRepositry.findFilterCoursesD();
    }

    @Override
    public List<CoursesFilterByDocente> findFilterCoursesByUsuarioDocente(Integer idUser) {
        return cursoRepositry.findFilterCoursesByUsuarioDocente(idUser);
    }

    @Override
    public List<CoursesFilterByDocente> findByIdUsuarioEstadoCursoFinalizado(Integer idUser) {
        return cursoRepositry.findByIdUsuarioEstadoCursoFinalizado(idUser);
    }

    @Override
    public Page<Curso> findByCapacitadorUsuarioIdUsuarioPageable(Integer idCapacitador, Pageable pageable) {
        return cursoRepositry.findByCapacitadorUsuarioIdUsuario(idCapacitador, pageable);
    }

    @Override
    @Transactional
    public Integer updateStatusCourseAcepted(Integer idCurso, String status) {
        return cursoRepositry.updateStatusCourseAcepted(idCurso, status);
    }

    @Override
    public List<Curso> findByAllC() {
        return cursoRepositry.findAll();
    }

    @Override
    @Async("asyncExecutor")
    public CompletableFuture<List<Curso>> findByAllAsync() {
        List<Curso> data = cursoRepositry.findAll();
        return CompletableFuture.completedFuture(data);
    }

    @Override
    public Page<ListCourseReduce> findByAllCourseDataReducePageable(Pageable pageable) {
        return cursoRepositry.findByAllCourseDataReducePageable(pageable);
    }

}
