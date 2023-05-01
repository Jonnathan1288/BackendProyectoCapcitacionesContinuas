package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.ContenidoSilabo;
import com.capacitaciones.continuas.models.EntornoAprendizajeCurricular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntornoAprendizajeCurricularRepository extends JpaRepository<EntornoAprendizajeCurricular, Integer> {
    List<EntornoAprendizajeCurricular> findByDisenioCurricularbyDisenio(Integer idDisenioCurricular);

}
