package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.Persona;
import com.capacitaciones.continuas.models.RegistroFotograficoCurso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroFotograficoCurosRepository extends JpaRepository<RegistroFotograficoCurso, Integer> {
}