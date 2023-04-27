package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.DisenioCurricular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisenioCurricularRepository extends JpaRepository<DisenioCurricular, Integer> {
}

