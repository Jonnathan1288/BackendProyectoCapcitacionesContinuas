package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Dtos.CoursesFilter;
import com.capacitaciones.continuas.Modelos.Primary.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CursoRepositry extends JpaRepository<Curso, Integer> {
    public List<Curso> findByCapacitadorUsuarioIdUsuario(Integer idCapacitador);
    List<Curso> findByEstadoCursoAndEstadoPublicasionCurso(boolean estadoCurso, String estadoCurso2);

    @Query( value = "SELECT c.* FROM cursos c INNER JOIN inscritos i ON c.id_curso = i.id_curso INNER JOIN usuarios u ON i.id_usuario = u.id_usuario INNER JOIN partipantesmatriculados pm ON i.id_inscrito = pm.id_inscrito WHERE u.id_usuario = :idParticipante", nativeQuery = true)
    List<Curso> findCursosDelParticipante(@Param("idParticipante") Integer idParticipante);


    @Query ("SELECT c.idCurso as idCurso, c.nombreCurso as nombreCurso, CONCAT(cap.tipoAbreviaturaTitulo, ' ', p.nombre1, ' ', p.apellido1) as docente FROM Curso c INNER JOIN c.capacitador cap INNER JOIN cap.usuario u INNER JOIN u.persona p WHERE c.estadoPublicasionCurso = 'F'")
    List<CoursesFilter> findFilterCoursesD();
}
