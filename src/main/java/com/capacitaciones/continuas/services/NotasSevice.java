package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Notas;
import com.capacitaciones.continuas.interfaces.NotasReduce;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotasSevice extends GenericService<Notas, Integer> {

    List<Notas> findByPartipantesMatriculadosInscritoCursoIdCurso(Integer idCurso);

    List<Notas> findByPartipantesMatriculadosIdParticipanteMatriculado(Integer idParticipantesFinales);

    Boolean validarExistenciaDeRegistroNotas(Integer idCurso);

    public List<NotasReduce> findAllNotasFinalesByIdCurso(Integer idCurso);


}
