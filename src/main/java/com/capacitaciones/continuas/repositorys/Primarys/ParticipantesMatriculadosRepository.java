package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Dtos.ListApproved;
import com.capacitaciones.continuas.Modelos.Primary.PartipantesMatriculados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ParticipantesMatriculadosRepository extends JpaRepository<PartipantesMatriculados, Integer> {
    public List<PartipantesMatriculados> findByInscritoCursoIdCurso(Integer idCurso);

    public boolean existsByInscritoCursoIdCurso(Integer idCurso);

    public List<PartipantesMatriculados> findByInscritoCursoIdCursoAndEstadoParticipanteAprobacion(Integer idCurso, String aprovado); // Method correction use..

    @Query("SELECT c.idCurso as idCurso, CONCAT(p.nombre1, ' ', p.nombre2, ' ', p.apellido1, ' ', p.apellido2) as nombres, c.nombreCurso as curso, c.fechaInicioCurso as fechaInicio, c.fechaFinalizacionCurso as fechaFin, c.duracionCurso as horas, CONCAT(cap.tipoAbreviaturaTitulo, ' ', docp.nombre1, ' ', docp.apellido1) as docente FROM PartipantesMatriculados m INNER JOIN m.inscrito ins INNER JOIN ins.curso c INNER JOIN ins.usuario user INNER JOIN user.persona p INNER JOIN c.capacitador cap INNER JOIN cap.usuario doc INNER JOIN doc.persona docp WHERE m.estadoParticipanteAprobacion = :status AND c.idCurso IN :courses")
    public List<ListApproved> findALlParticipantesAprovadosByIdCursos(@Param("status") String status, @Param("courses") List<Integer> courses);
}

