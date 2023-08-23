package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.PartipantesMatriculados;
import com.capacitaciones.continuas.services.generic.GenericService;

import java.util.List;

public interface ParticipantesMatriculadosService extends GenericService<PartipantesMatriculados, Integer> {
    public List<PartipantesMatriculados> findByInscritoCursoIdCurso(Integer idCurso);

    public boolean existsByInscritoCursoIdCurso(Integer idCurso);

    public List<PartipantesMatriculados> findByInscritoCursoIdCursoAndEstadoParticipanteAprobacion(Integer idCurso); // Method correction use..



}
