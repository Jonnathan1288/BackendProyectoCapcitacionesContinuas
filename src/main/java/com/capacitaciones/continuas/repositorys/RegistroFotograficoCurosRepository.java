package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.RegistroFotograficoCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroFotograficoCurosRepository extends JpaRepository<RegistroFotograficoCurso, Integer> {
    public List<RegistroFotograficoCurso> findByCursoIdCurso(Integer idCurso);
}