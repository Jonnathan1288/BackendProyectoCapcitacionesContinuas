package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepositry extends JpaRepository<Curso, Integer> {
}
