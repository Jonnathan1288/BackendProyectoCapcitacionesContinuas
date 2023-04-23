package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.DetalleEvaluacionFinal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleEvaluacionFinalRepositorty extends JpaRepository<DetalleEvaluacionFinal, Integer> {
}
