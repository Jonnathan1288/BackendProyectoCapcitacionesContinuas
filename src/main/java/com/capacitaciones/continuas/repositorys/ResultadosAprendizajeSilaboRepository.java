package com.capacitaciones.continuas.repositorys;


import com.capacitaciones.continuas.models.ResultadoAprendizajeSilabo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadosAprendizajeSilaboRepository extends JpaRepository<ResultadoAprendizajeSilabo, Integer> {
}
