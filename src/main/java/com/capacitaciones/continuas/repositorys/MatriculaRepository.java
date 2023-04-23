package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {
}
