package com.capacitaciones.continuas.repositorys;


import com.capacitaciones.continuas.models.ControlHorario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlHorarioRepository extends JpaRepository<ControlHorario, Integer> {
}

