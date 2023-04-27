package com.capacitaciones.continuas.repositorys;

import models.PeriodoPrograma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodoProgramaRepository extends JpaRepository<PeriodoPrograma, Integer> {
}
