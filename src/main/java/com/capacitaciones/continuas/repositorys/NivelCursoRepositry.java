package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.Curso;
import com.capacitaciones.continuas.models.NivelCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelCursoRepositry extends JpaRepository<NivelCurso, Integer> {
}
