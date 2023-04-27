package com.capacitaciones.continuas.services;

import models.PartipantesMatriculados;
import com.capacitaciones.continuas.repositorys.ParticipantesMatriculadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ParticipantesMatriculadosServiceImpl extends GenericServiceImpl<PartipantesMatriculados, Integer> implements ParticipantesMatriculadosService {

    @Autowired
    ParticipantesMatriculadosRepository participantesMatriculadosRepository;

    @Override
    public CrudRepository<PartipantesMatriculados, Integer> getDao() {
        return participantesMatriculadosRepository;
    }
}
