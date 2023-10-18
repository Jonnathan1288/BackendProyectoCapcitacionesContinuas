package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.Notas;
import com.capacitaciones.continuas.interfaces.NotasReduce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotasRepository extends JpaRepository<Notas, Integer> {
    List<Notas> findByPartipantesMatriculadosInscritoCursoIdCurso(Integer idCurso);

    public Boolean existsByPartipantesMatriculadosInscritoCursoIdCurso(Integer idCurso);

    List<Notas> findByPartipantesMatriculadosIdParticipanteMatriculado(Integer idParticipantesFinales);

    //public boolean
    @Query("SELECT n.idNota AS idNota, "+
            "n.informe1 AS informe1, "+
            "n.informe2 AS informe2, "+
            "n.informe3 AS informe3, "+
            "n.examenFinal AS examenFinal, "+
            "n.fechaNota AS fechaNota, " +
            "n.observacion AS observacion, "+
            "n.partipantesMatriculados.idParticipanteMatriculado AS idParticipanteMatriculado, "+
            "CONCAT(ins.usuario.persona.apellido1, ' ', ins.usuario.persona.apellido2, ' ', ins.usuario.persona.nombre1, ' ', ins.usuario.persona.nombre2) AS nombres, "+
            "ins.usuario.persona.identificacion AS identificacion, "+
            "c.idCurso AS idCurso, "+
            "c.nombreCurso AS nombreCurso, "+
            "c.fechaInicioCurso AS fechaInicioCurso, "+
            "c.fechaFinalizacionCurso AS fechaFinalizacionCurso "+
            "FROM Notas n "+
            "INNER JOIN n.partipantesMatriculados pm "+
            "INNER JOIN pm.inscrito ins "+
            "INNER JOIN ins.curso c "+
            "WHERE c.idCurso = :idCurso "+
            "ORDER BY c.idCurso asc")
    public List<NotasReduce> findAllNotasFinalesByIdCurso(@Param("idCurso") Integer idCurso);

}
