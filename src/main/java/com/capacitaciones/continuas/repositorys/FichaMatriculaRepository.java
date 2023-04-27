package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.FichaMatricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaMatriculaRepository extends JpaRepository<FichaMatricula, Integer> {
}

