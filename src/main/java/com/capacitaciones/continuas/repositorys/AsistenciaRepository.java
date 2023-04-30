package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.Asistencia;
import com.capacitaciones.continuas.models.PartipantesMatriculados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {
    public Boolean existsByFechaAsistencia(LocalDate fecha);

    public List<Asistencia> findByPartipantesMatriculadosInscritoCursoIdCursoAndFechaAsistencia(Integer idCurso, LocalDate fecha);


    //public List<PartipantesMatriculados> findByInscritoCursoIdCurso(Integer idCurso);
}
