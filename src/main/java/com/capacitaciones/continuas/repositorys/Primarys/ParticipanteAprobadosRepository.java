package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.interfaces.ListApproved;
import com.capacitaciones.continuas.Modelos.Primary.ParticipantesAprobados;
import com.capacitaciones.continuas.interfaces.ParticipantsApproved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipanteAprobadosRepository extends JpaRepository<ParticipantesAprobados, Integer> {
    public List<ParticipantesAprobados> findByPartipantesMatriculadosInscritoCursoIdCurso(Integer idCurso);
    public boolean existsByPartipantesMatriculadosInscritoCursoIdCurso(Integer idCurso);

    //Por el momento este metodo no se va poner en uso pero queda vijente para otro uso..
    @Query("SELECT p "+
            "FROM ParticipantesAprobados p "+
            "INNER JOIN p.partipantesMatriculados pm "+
            "INNER JOIN pm.inscrito ins "+
            "INNER JOIN ins.curso cu "+
            "INNER JOIN ins.usuario u "+
            "INNER JOIN u.persona per "+
            "WHERE cu.idCurso = :idCurso AND per.identificacion = :ci")
    public ParticipantesAprobados findByCursoAndUsuario(@Param("idCurso") Integer idCurso, @Param("ci") String ci);


    //NEW METHODS-------------------------------------------------------------------------
    @Query("SELECT c.idCurso as idCurso, "+
           "CONCAT(p.nombre1, ' ', p.nombre2, ' ', p.apellido1, ' ', p.apellido2) as nombres, "+
           "ap.codigoSenecyt as codigoSenecyt, "+
    "ap.idParticipantesAprobados as idParticipantesAprobados, "+
    "m.idParticipanteMatriculado as idParticipanteMatriculado, "+
    "c.nombreCurso as curso, "+
    "c.fechaInicioCurso as fechaInicio, "+
    "c.fechaFinalizacionCurso as fechaFin, "+
    "c.duracionCurso as horas, "+
            "CONCAT(cap.tipoAbreviaturaTitulo, ' ', docp.nombre1, ' ', docp.apellido1) as docente "+
            "FROM ParticipantesAprobados ap "+
            "INNER JOIN ap.partipantesMatriculados m "+
            "INNER JOIN m.inscrito ins "+
            "INNER JOIN ins.curso c "+
            "INNER JOIN ins.usuario user "+
            "INNER JOIN user.persona p "+
            "INNER JOIN c.capacitador cap "+
            "INNER JOIN cap.usuario doc "+
            "INNER JOIN doc.persona docp "+
            "WHERE m.estadoParticipanteAprobacion = :status AND c.idCurso IN :courses")
    public List<ListApproved> findALlParticipantesAprovadosByIdCursos(@Param("status") String status, @Param("courses") List<Integer> courses);

    //THIS METHOD USED IN UPDATE CODE....
    @Query("SELECT ap FROM ParticipantesAprobados ap "+
            "INNER JOIN ap.partipantesMatriculados m "+
            "INNER JOIN m.inscrito ins "+
            "INNER JOIN ins.curso c "+
            "INNER JOIN ins.usuario user "+
            "INNER JOIN user.persona p "+
            "INNER JOIN c.capacitador cap "+
            "INNER JOIN cap.usuario doc "+
            "INNER JOIN doc.persona docp "+
            "WHERE m.estadoParticipanteAprobacion = :status AND c.idCurso IN :courses")
    public List<ParticipantesAprobados> findALlParticipantesAprovadosAndUpdateByIdCursos(@Param("status") String status, @Param("courses") List<Integer> courses);

    @Query("SELECT c.idCurso as idCurso, "+
    "CONCAT(p.nombre1, ' ', p.nombre2) as nombres, "+
            "CONCAT(p.apellido1, ' ', p.apellido2) as apellidos, "+
            "p.identificacion as identificacion "+
            "FROM ParticipantesAprobados ap "+
            "INNER JOIN ap.partipantesMatriculados m "+
            "INNER JOIN m.inscrito ins "+
            "INNER JOIN ins.curso c "+
            "INNER JOIN ins.usuario user "+
            "INNER JOIN user.persona p "+
            "INNER JOIN c.capacitador cap "+
            "INNER JOIN cap.usuario doc "+
            "INNER JOIN doc.persona docp "+
            "WHERE m.estadoParticipanteAprobacion = :status "+
            "AND c.idCurso  = :idCurso")
    public List<ParticipantsApproved> findALlParticipantesAprovadosByIdDocenteCourse(@Param("status") String status, @Param("idCurso") Integer idCurso);

}

