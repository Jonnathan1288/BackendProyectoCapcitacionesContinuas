package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.models.PartipantesMatriculados;
import com.capacitaciones.continuas.repositorys.ParticipantesMatriculadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class ParticipantesMatriculadosServiceImpl extends GenericServiceImpl<PartipantesMatriculados, Integer> implements ParticipantesMatriculadosService {

    @Autowired
    ParticipantesMatriculadosRepository participantesMatriculadosRepository;

    @Override
    public CrudRepository<PartipantesMatriculados, Integer> getDao() {
        return participantesMatriculadosRepository;
    }
}
