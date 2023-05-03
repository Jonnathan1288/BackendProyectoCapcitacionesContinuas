package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.ParticipantesAprobados;
import com.capacitaciones.continuas.repositorys.Primarys.ParticipanteAprobadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ParticipantesAprobadosServiceImpl  extends GenericServiceImpl<ParticipantesAprobados, Integer> implements ParticipantesAprobadosService {

    @Autowired
    ParticipanteAprobadosRepository participanteAprobadosRepository;

    @Override
    public CrudRepository<ParticipantesAprobados, Integer> getDao() {
        return participanteAprobadosRepository;
    }
}
