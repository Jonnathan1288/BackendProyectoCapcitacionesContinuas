package com.capacitaciones.continuas.repositorys.Primarys;


import com.capacitaciones.continuas.Modelos.Primary.Programas;
import com.capacitaciones.continuas.interfaces.ChartProgramaCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramasRepository extends JpaRepository<Programas , Integer> {

    @Query("SELECT p.nombrePrograma as nombrePrograma, c.nombreCurso as nombreCurso, c.numeroCuposCurso as numeroCuposCurso  FROM Curso c INNER JOIN c.programas p")
    public List<ChartProgramaCourse> findProgramaCourseChart();
}
