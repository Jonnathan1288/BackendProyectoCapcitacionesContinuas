package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.PartipantesMatriculados;
import com.capacitaciones.continuas.interfaces.MatriculadoReduce;
import com.capacitaciones.continuas.repositorys.Primarys.ParticipantesMatriculadosRepository;
import com.capacitaciones.continuas.services.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ParticipantesMatriculadosServiceImpl extends GenericServiceImpl<PartipantesMatriculados, Integer> implements ParticipantesMatriculadosService {

    @Autowired
    ParticipantesMatriculadosRepository participantesMatriculadosRepository;

    @Override
    public CrudRepository<PartipantesMatriculados, Integer> getDao() {
        return participantesMatriculadosRepository;
    }

    @Override
    public List<PartipantesMatriculados> findByInscritoCursoIdCurso(Integer idCurso) {
        return participantesMatriculadosRepository.findByInscritoCursoIdCurso(idCurso);
    }

    @Override
    public boolean existsByInscritoCursoIdCurso(Integer idCurso) {
        return participantesMatriculadosRepository.existsByInscritoCursoIdCurso(idCurso);
    }

    @Override
    public List<PartipantesMatriculados> findByInscritoCursoIdCursoAndEstadoParticipanteAprobacion(Integer idCurso) {
        //Este metodo recojera toda la información de la anterior tabla.
        return participantesMatriculadosRepository.findByInscritoCursoIdCursoAndEstadoParticipanteAprobacion(idCurso, "A");
    }

    @Override
    public List<MatriculadoReduce> findByAllMatriculadoCursoDocenteCapacitador(Integer idCurso) {
        return participantesMatriculadosRepository.findByAllMatriculadoCursoDocenteCapacitador(idCurso);
    }

    @Override
    @Transactional
    public Integer updateEstadoAprobacionParticipanteMatriculado(Integer idPm, String status) {
        return participantesMatriculadosRepository.updateEstadoAprobacionParticipanteMatriculado(idPm, status);
    }


}
