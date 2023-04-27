package com.capacitaciones.continuas.repositorys;

import models.NivelCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelCursoRepositry extends JpaRepository<NivelCurso, Integer> {
}
