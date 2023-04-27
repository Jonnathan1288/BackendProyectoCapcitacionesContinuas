package com.capacitaciones.continuas.repositorys;

import models.Notas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotasRepository extends JpaRepository<Notas, Integer> {
}
