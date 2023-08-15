package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Dtos.ListApproved;
import com.capacitaciones.continuas.Modelos.Primary.PartipantesMatriculados;
import com.capacitaciones.continuas.repositorys.Primarys.ParticipantesMatriculadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

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
    public List<ListApproved> findALlParticipantesAprovadosByIdCursos(List<Integer> courses) {
        return participantesMatriculadosRepository.findALlParticipantesAprovadosByIdCursos("A", courses);
    }
}
