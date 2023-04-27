package com.capacitaciones.continuas.repositorys;

import models.RegistroFotograficoCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroFotograficoCurosRepository extends JpaRepository<RegistroFotograficoCurso, Integer> {
}