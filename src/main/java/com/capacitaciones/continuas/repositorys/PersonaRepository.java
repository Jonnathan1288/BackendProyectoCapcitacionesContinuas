package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
