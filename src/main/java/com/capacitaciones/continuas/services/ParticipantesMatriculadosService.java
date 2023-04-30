package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.models.PartipantesMatriculados;

import java.util.List;

public interface ParticipantesMatriculadosService extends GenericService<PartipantesMatriculados, Integer>{
    public List<PartipantesMatriculados> findByInscritoCursoIdCurso(Integer idCurso);
}
