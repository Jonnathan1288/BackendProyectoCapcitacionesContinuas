package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer> {
    public List<Especialidad> findByAreaIdArea(Integer idArea);
}

