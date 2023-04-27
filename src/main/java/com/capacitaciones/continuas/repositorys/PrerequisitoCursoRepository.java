package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.PrerequisitoCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrerequisitoCursoRepository extends JpaRepository<PrerequisitoCurso, Integer> {
}
