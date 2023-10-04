package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.interfaces.CoursesFilter;
import com.capacitaciones.continuas.Modelos.Primary.Curso;
import com.capacitaciones.continuas.interfaces.CoursesFilterByDocente;
import com.capacitaciones.continuas.interfaces.ListCourseReduce;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepositry extends GenericRepository<Curso, Integer> {
    public List<Curso> findByCapacitadorUsuarioIdUsuario(Integer idCapacitador);
    List<Curso> findByEstadoCursoAndEstadoPublicasionCurso(boolean estadoCurso, String estadoCurso2);

    @Query( value = "SELECT c.* FROM cursos c INNER JOIN inscritos i ON c.id_curso = i.id_curso INNER JOIN usuarios u ON i.id_usuario = u.id_usuario INNER JOIN partipantesmatriculados pm ON i.id_inscrito = pm.id_inscrito WHERE u.id_usuario = :idParticipante", nativeQuery = true)
    List<Curso> findCursosDelParticipante(@Param("idParticipante") Integer idParticipante);


    @Query ("SELECT c.idCurso as idCurso, "+
            "c.nombreCurso as nombreCurso, "+
            "CONCAT(cap.tipoAbreviaturaTitulo, ' ', p.nombre1, ' ', p.apellido1) as docente "+
            "FROM Curso c "+
            "INNER JOIN c.capacitador cap "+
            "INNER JOIN cap.usuario u "+
            "INNER JOIN u.persona p "+
            "WHERE c.estadoPublicasionCurso = 'F' "+
            "ORDER BY idCurso DESC")
    public List<CoursesFilter> findFilterCoursesD();

    @Query ("SELECT c.idCurso as idCurso, "+
            "c.nombreCurso as nombreCurso, "+
            "CONCAT(cap.tipoAbreviaturaTitulo, ' ', cap.usuario.persona.nombre1, ' ', cap.usuario.persona.apellido1) as docente, "+
            "c.estadoPublicasionCurso as estadoPublicasionCurso, "+
            "c.estadoAprovacionCurso as estadoAprovacionCurso "+
            "FROM Curso c INNER JOIN c.capacitador cap "+
            "WHERE cap.usuario.idUsuario = :idUser "+
            "ORDER BY idCurso DESC")
    public List<CoursesFilterByDocente> findFilterCoursesByUsuarioDocente(@Param("idUser") Integer idUser);

    @Query ("SELECT c.idCurso as idCurso, "+
            "c.nombreCurso as nombreCurso, "+
            "CONCAT(cap.tipoAbreviaturaTitulo, ' ', cap.usuario.persona.nombre1, ' ', cap.usuario.persona.apellido1) as docente, "+
            "c.estadoPublicasionCurso as estadoPublicasionCurso, "+
            "c.estadoAprovacionCurso as estadoAprovacionCurso "+
            "FROM Curso c INNER JOIN c.capacitador cap "+
            "WHERE cap.usuario.idUsuario = :idUser "+
            "AND c.estadoPublicasionCurso = 'F'"+
            "ORDER BY idCurso DESC")
    public List<CoursesFilterByDocente> findByIdUsuarioEstadoCursoFinalizado(@Param("idUser") Integer idUser);

    public Page<Curso> findByCapacitadorUsuarioIdUsuario(Integer idCapacitador, Pageable pageable);

    //NEW ----------------------------------------------------------------------------------------
    @Modifying
    @Query("UPDATE Curso c SET c.estadoAprovacionCurso = :status WHERE c.idCurso = :idCurso")
    public Integer updateStatusCourseAcepted(@Param("idCurso") Integer idCurso, @Param("status") String status);

    @Query("SELECT c.idCurso as idCurso, "+
            "c.fechaInicioCurso as fechaInicio, "+
            "c.nombreCurso as nameCourse, "+
            "c.fechaFinalizacionCurso as fechaFin, "+
            "c.estadoAprovacionCurso as statusApproved, "+
            "c.estadoCurso as statusFinalized, "+
            "p.nombrePrograma as nameProgram, "+
            "cap.usuario.username as username, "+
            "CONCAT(cap.tipoAbreviaturaTitulo, ' ', cap.usuario.persona.nombre1, ' ', cap.usuario.persona.apellido1) as docente, "+
            "cap.usuario.persona.correo as email, "+
            "cap.usuario.fotoPerfil as urlPhoto "+
            "FROM Curso c "+
            "INNER JOIN c.programas p "+
            "INNER JOIN c.capacitador cap "+
            "ORDER BY c.idCurso DESC")
    public Page<ListCourseReduce> findByAllCourseDataReducePageable(Pageable pageable);
}
