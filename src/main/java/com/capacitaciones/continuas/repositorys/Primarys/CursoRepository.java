package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.interfaces.CoursesFilter;
import com.capacitaciones.continuas.Modelos.Primary.Curso;
import com.capacitaciones.continuas.interfaces.CoursesFilterByDocente;
import com.capacitaciones.continuas.interfaces.ListCourseReduce;
import com.capacitaciones.continuas.payload.PayloadCurso;
import com.capacitaciones.continuas.payload.PayloadEncabezadoNotasFinales;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends GenericRepository<Curso, Integer> {
    public List<Curso> findByCapacitadorUsuarioIdUsuario(Integer idCapacitador);
    List<Curso> findByEstadoCursoAndEstadoPublicasionCurso(boolean estadoCurso, String estadoCurso2);

    @Query("SELECT c.idCurso AS idCurso, c.fotoCurso AS fotoCurso, c.nombreCurso AS nombreCurso, p.nombre1 || p.apellido1 AS nombre, c.duracionCurso AS duracionCurso, h.horaInicio as horaInicio,  h.horaFin as horaFin, h.dias as dias,c.fechaInicioCurso as fechaInicioCurso, c.fechaFinalizacionCurso as fechaFinalizacionCurso, c.numeroCuposCurso as numeroCuposCurso, m.nombreModalidadCurso as nombreModalidadCurso, t.nombreTipoCurso as nombreTipoCurso, n.nombreNivelCurso as nombreNivelCurso, e.nombreEspecialidad as nombreEspecialidad FROM Curso c JOIN c.capacitador ca JOIN ca.usuario u JOIN u.persona p JOIN c.modalidadCurso m JOIN c.horarioCurso h JOIN c.nivelCurso n JOIN  c.tipoCurso t JOIN c.especialidad e  WHERE c.estadoCurso = true and c.estadoPublicasionCurso ='V'")
    public Page<PayloadCurso> findByEstadoCursoPublicado(Pageable pageable);

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

    @Modifying
    @Query("UPDATE Curso c SET c.estadoPublicasionCurso = :status WHERE c.idCurso = :idCurso")
    public Integer updateCourseStatus(@Param("idCurso") Integer idCurso, @Param("status") String status);


    @Query(value = "SELECT c.id_curso AS idCurso, c.nombre_curso AS nombreCurso, hc.hora_inicio AS horaInicio, hc.hora_fin AS horaFin, c.fecha_inicio_curso AS fechaInicioCurso, mc.nombre_modalidad_curso AS nombreModalidadCurso, c.duracion_curso AS duracionCurso, c.codigo_curso AS codigoCurso, c.fecha_finalizacion_curso AS fechaFinalizacionCurso, CONCAT(p.apellido1, ' ', p.apellido2, ' ', p.nombre1, ' ', p.nombre2) AS nombreDocente, c.observacion_curso AS observacionCurso, inf.canton_informe_final_curso AS cantonInformeFinalCurso FROM cursos c INNER JOIN horarioscursos hc ON c.id_horario_curso = hc.id_horario_curso INNER JOIN modalidades_cursos mc ON mc.id_modalidad_curso = c.id_modalidad_curso INNER JOIN tipos_cursos tc ON tc.id_tipo_curso = c.id_tipo_curso INNER JOIN capacitadores cap ON c.id_capacitador = cap.id_capacitador INNER JOIN usuarios us ON us.id_usuario = cap.id_usuario INNER JOIN personas p ON p.id_persona = us.id_persona INNER JOIN inscritos ins ON ins.id_curso = c.id_curso INNER JOIN partipantesmatriculados pm ON pm.id_inscrito = ins.id_inscrito INNER JOIN asistencias asis ON asis.id_participante_matriculado = pm.id_participante_matriculado INNER JOIN informefinalcursos inf ON inf.id_curso = c.id_curso WHERE c.id_curso = :idCurso GROUP BY c.id_curso, p.id_persona, mc.id_modalidad_curso, inf.id_informe_final_curso",  nativeQuery = true)
    public PayloadEncabezadoNotasFinales getEncabezadoNotasFinales(@Param("idCurso")Integer idCurso);


}
