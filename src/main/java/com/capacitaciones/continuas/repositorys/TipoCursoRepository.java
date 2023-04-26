package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.Area;
import com.capacitaciones.continuas.models.TipoCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCursoRepository extends JpaRepository<TipoCurso, Integer> {
}
