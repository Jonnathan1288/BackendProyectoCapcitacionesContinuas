package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.PartipantesMatriculados;
import com.capacitaciones.continuas.interfaces.MatriculadoReduce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantesMatriculadosRepository extends JpaRepository<PartipantesMatriculados, Integer> {
    public List<PartipantesMatriculados> findByInscritoCursoIdCurso(Integer idCurso);

    public boolean existsByInscritoCursoIdCurso(Integer idCurso);

    public List<PartipantesMatriculados> findByInscritoCursoIdCursoAndEstadoParticipanteAprobacion(Integer idCurso, String aprovado); // Method correction use..

    @Query("SELECT pm.idParticipanteMatriculado as idCursoMatricula, "+
            "i.curso.idCurso as idCurso, "+
            "CONCAT(u.persona.nombre1, ' ', u.persona.nombre2, ' ', u.persona.apellido1, ' ', u.persona.apellido2) as nombres,  "+
            "u.persona.correo as email, "+
            "u.persona.identificacion as identificacion, "+
            "u.persona.celular as celular, "+
            "u.persona.genero as genero FROM PartipantesMatriculados pm "+
            "INNER JOIN pm.inscrito i "+
            "INNER JOIN i.usuario u WHERE pm.inscrito.curso.idCurso = :idCurso")
    public List<MatriculadoReduce> findByAllMatriculadoCursoDocenteCapacitador(@Param("idCurso") Integer idCurso);

}

