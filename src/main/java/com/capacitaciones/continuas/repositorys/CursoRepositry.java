package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepositry extends JpaRepository<Curso, Integer> {
}
