package com.capacitaciones.continuas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SelectNative {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> ejecutarConsultaSql(Long cursoId) {

        String sql = "SELECT CONCAT(p.apellido1, ' ', p.apellido2, ' ', p.nombre1, ' ', p.nombre2) AS estudiante, " +
                "p.identificacion, " +
                "REPLACE(d.dias, ' | ', ',') AS dias, " +
                "GROUP_CONCAT(DISTINCT n.observacion SEPARATOR ', ') AS observacion, " +
                "GROUP_CONCAT(CASE WHEN a.estado_asistencia = 1 THEN 'X' ELSE 'O' END SEPARATOR ',') AS asistencia, " +
                "MAX(n.informe1) AS informe1, " +
                "MAX(n.informe2) AS informe2, " +
                "MAX(n.informe3) AS informe3, " +
                "MAX(n.examen_final) AS examen_final, " +
                "SUM(n.informe1 + n.informe2 + n.informe3 + n.examen_final) OVER (PARTITION BY p.id_persona) as total, " +
                "aprueba.estado_aprobacion " +
                "FROM personas p " +
                "INNER JOIN usuarios u ON u.id_persona = p.id_persona " +
                "INNER JOIN inscritos i ON i.id_usuario = u.id_usuario " +
                "INNER JOIN partipantesmatriculados pm ON pm.id_inscrito = i.id_inscrito " +
                "INNER JOIN notas n ON n.id_participante_matriculado = pm.id_participante_matriculado " +
                "INNER JOIN cursos c ON c.id_curso = i.id_curso " +
                "INNER JOIN asistencias a ON a.id_participante_matriculado = pm.id_participante_matriculado " +
                "INNER JOIN horarioscursos hc ON hc.id_horario_curso = c.id_horario_curso " +
                "INNER JOIN (SELECT DISTINCT c.id_curso, GROUP_CONCAT(CASE DAYOFWEEK(DATE_ADD(c.fecha_inicio_curso, INTERVAL (numbers.n - 1) DAY)) " +
                "WHEN 1 THEN 'Domingo' " +
                "WHEN 2 THEN 'Lunes' " +
                "WHEN 3 THEN 'Martes' " +
                "WHEN 4 THEN 'Miércoles' " +
                "WHEN 5 THEN 'Jueves' " +
                "WHEN 6 THEN 'Viernes' " +
                "WHEN 7 THEN 'Sábado' " +
                "END SEPARATOR ' | ' ) AS dias " +
                "FROM cursos c " +
                "INNER JOIN horarioscursos hc ON hc.id_horario_curso = c.id_horario_curso " +
                "INNER JOIN (SELECT @row := @row + 1 AS n FROM (SELECT 0 AS dummy UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) t1 " +
                "CROSS JOIN (SELECT 0 AS dummy UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9) t2 " +
                "CROSS JOIN (SELECT @row := 0) vars ) numbers " +
                "WHERE c.id_curso = "+cursoId+" " +
                "AND ( " +
                "(hc.dias = 'Lunes-Domingo') OR " +
                "(hc.dias = 'Lunes-Viernes' AND DAYOFWEEK(DATE_ADD(c.fecha_inicio_curso, INTERVAL (numbers.n - 1) DAY)) BETWEEN 2 AND 6) " +
                "OR " +
                "(hc.dias = 'Sábados' AND DAYOFWEEK(DATE_ADD(c.fecha_inicio_curso, INTERVAL (numbers.n - 1) DAY)) = 7) " +
                "OR " +
                "(hc.dias = 'Domingos' AND DAYOFWEEK(DATE_ADD(c.fecha_inicio_curso, INTERVAL (numbers.n - 1) DAY)) = 1) " +
                ") " +
                "AND DATE_ADD(c.fecha_inicio_curso, INTERVAL (numbers.n - 1) DAY) <= c.fecha_finalizacion_curso " +
                "GROUP BY c.id_curso ) d ON c.id_curso = d.id_curso " +
                "LEFT JOIN (SELECT pm.id_participante_matriculado, " +
                "CASE " +
                "WHEN pm.estado_participante_aprobacion = 'A' THEN 'Aprobado' " +
                "ELSE 'Reprobado' " +
                "END AS estado_aprobacion " +
                "FROM partipantesmatriculados pm ) aprueba ON aprueba.id_participante_matriculado = pm.id_participante_matriculado " +
                "WHERE c.id_curso = "+cursoId+" " +
                "GROUP BY p.id_persona, d.dias, estudiante, p.identificacion, informe1";

        return  jdbcTemplate.queryForList(sql);

        //return jdbcTemplate.queryForList(sql);
    }
}


       /* String sql = "SELECT " +
                "CONCAT(p.apellido1, ' ', p.apellido2, ' ', p.nombre1, ' ', p.nombre2) AS estudiante, " +
                "p.identificacion, " +
                "REPLACE(d.dias, ' | ', ',') AS dias, " +
                "GROUP_CONCAT(DISTINCT n.observacion SEPARATOR ', ') AS observacion, " +
                "GROUP_CONCAT(CASE WHEN a.estado_asistencia = 1 THEN 'X' ELSE 'O' END SEPARATOR ',') AS asistencia, " +
                "MAX(n.informe1) AS informe1, " +
                "MAX(n.informe2) AS informe2, " +
                "MAX(n.informe3) AS informe3, " +
                "MAX(n.examen_final) AS examen_final, " +
                "SUM(n.informe1 + n.informe2 + n.informe3 + n.examen_final) OVER (PARTITION BY p.id_persona) as total, " +
                "aprueba.estado_aprobacion " +
                "FROM personas p " +
                "INNER JOIN usuarios u ON u.id_persona = p.id_persona " +
                "INNER JOIN inscritos i ON i.id_usuario = u.id_usuario " +
                "INNER JOIN partipantesmatriculados pm ON pm.id_inscrito = i.id_inscrito " +
                "INNER JOIN notas n ON n.id_participante_matriculado = pm.id_participante_matriculado " +
                "INNER JOIN cursos c ON c.id_curso = i.id_curso " +
                "INNER JOIN asistencias a ON a.id_participante_matriculado = pm.id_participante_matriculado " +
                "INNER JOIN horarioscursos hc ON hc.id_horario_curso = c.id_horario_curso " +
                "INNER JOIN ( " +
                "    SELECT DISTINCT " +
                "        c.id_curso, " +
                "        GROUP_CONCAT( " +
                "            CASE DAYOFWEEK(DATE_ADD(c.fecha_inicio_curso, INTERVAL (numbers.n - 1) DAY)) " +
                "                WHEN 1 THEN 'Domingo' " +
                "                WHEN 2 THEN 'Lunes' " +
                "                WHEN 3 THEN 'Martes' " +
                "                WHEN 4 THEN 'Miércoles' " +
                "                WHEN 5 THEN 'Jueves' " +
                "                WHEN 6 THEN 'Viernes' " +
                "                WHEN 7 THEN 'Sábado' " +
                "            END " +
                "            SEPARATOR ' | ' " +
                "        ) AS dias " +
                "    FROM cursos c " +
                "    INNER JOIN horarioscursos hc ON hc.id_horario_curso = c.id_horario_curso " +
                "    INNER JOIN ( " +
                "        SELECT " +
                "            @row := @row + 1 AS n " +
                "        FROM ( " +
                "            SELECT 0 AS dummy UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9 " +
                "        ) t1 " +
                "        CROSS JOIN ( " +
                "            SELECT 0 AS dummy UNION ALL SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9 " +
                "        ) t2 " +
                "        CROSS JOIN ( " +
                "            SELECT @row := 0 " +
                "        ) vars " +
                "    ) numbers " +
                "    WHERE c.id_curso = :cursoId " +
                "    AND ( " +
                "        (hc.dias = 'Lunes-Domingo') OR " +
                "        (hc.dias = 'Lunes-Viernes' AND DAYOFWEEK(DATE_ADD(c.fecha_inicio_curso, INTERVAL (numbers.n - 1) DAY)) BETWEEN 2 AND 6) " +
                "        OR " +
                "        (hc.dias = 'Sábados' AND DAYOFWEEK(DATE_ADD(c.fecha_inicio_curso, INTERVAL (numbers.n - 1) DAY)) = 7) " +
                "        OR " +
                "        (hc.dias = 'Domingos' AND DAYOFWEEK(DATE_ADD(c.fecha_inicio_curso, INTERVAL (numbers.n - 1) DAY)) = 1) " +
                "    ) " +
                "    AND DATE_ADD(c.fecha_inicio_curso, INTERVAL (numbers.n - 1) DAY) <= c.fecha_finalizacion_curso " +
                "    GROUP BY c.id_curso " +
                ") d ON c.id_curso = d.id_curso " +
                "LEFT JOIN ( " +
                "    SELECT " +
                "        pm.id_participante_matriculado, " +
                "        CASE " +
                "            WHEN pm.estado_participante_aprobacion = 'A' THEN 'Aprobado' " +
                "            ELSE 'Reprobado' " +
                "        END AS estado_aprobacion " +
                "    FROM partipantesmatriculados pm " +
                ") aprueba ON aprueba.id_participante_matriculado = pm.id_participante_matriculado " +
                "WHERE c.id_curso = :cursoId " +
                "GROUP BY p.id_persona, d.dias, estudiante, p.identificacion, informe1";*/