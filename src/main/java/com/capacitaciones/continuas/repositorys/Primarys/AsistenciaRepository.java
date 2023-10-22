package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.Asistencia;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AsistenciaRepository extends GenericRepository<Asistencia, Integer> {
    //public Boolean existsByFechaAsistencia(LocalDate fecha); //

    public Boolean existsByPartipantesMatriculadosInscritoCursoIdCursoAndFechaAsistencia(Integer idCurso,LocalDate fecha);

    public List<Asistencia> findByPartipantesMatriculadosInscritoCursoIdCursoAndFechaAsistencia(Integer idCurso, LocalDate fecha);


}
