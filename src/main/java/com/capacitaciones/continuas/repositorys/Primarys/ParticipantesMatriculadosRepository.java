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

}

