package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.interfaces.CoursesFilter;
import com.capacitaciones.continuas.Modelos.Primary.Curso;
import com.capacitaciones.continuas.repositorys.Primarys.CursoRepositry;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImpl;
import com.capacitaciones.continuas.services.generic.GenericServiceImplv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl extends GenericServiceImplv2<Curso, Integer> implements CursoService{
    @Autowired
    private CursoRepositry cursoRepositry;
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

}
