package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.Notas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotasRepository extends JpaRepository<Notas, Integer> {
    List<Notas> findByPartipantesMatriculadosInscritoCursoIdCurso(Integer idCurso);

    List<Notas> findByPartipantesMatriculadosIdParticipanteMatriculado(Integer idParticipantesFinales);

}
