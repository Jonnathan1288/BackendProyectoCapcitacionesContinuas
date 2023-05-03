package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.EntornoAprendizajeCurricular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntornoAprendizajeCurricularRepository extends JpaRepository<EntornoAprendizajeCurricular, Integer> {
}
