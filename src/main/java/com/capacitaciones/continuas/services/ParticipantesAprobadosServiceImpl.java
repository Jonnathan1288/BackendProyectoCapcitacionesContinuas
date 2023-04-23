package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.models.ParticipantesAprobados;
import com.capacitaciones.continuas.repositorys.ParticipanteAprobadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class ParticipantesAprobadosServiceImpl  extends GenericServiceImpl<ParticipantesAprobados, Integer> implements ParticipantesAprobadosService {

    @Autowired
    ParticipanteAprobadosRepository participanteAprobadosRepository;

    @Override
    public CrudRepository<ParticipantesAprobados, Integer> getDao() {
        return participanteAprobadosRepository;
    }
}
