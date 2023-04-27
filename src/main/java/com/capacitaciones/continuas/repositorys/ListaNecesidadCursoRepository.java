package com.capacitaciones.continuas.repositorys;

import models.ListaNecesidadCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaNecesidadCursoRepository extends JpaRepository<ListaNecesidadCurso, Integer> {
}
