package com.capacitaciones.continuas.repositorys;

import models.TipoCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCursoRepository extends JpaRepository<TipoCurso, Integer> {
}
