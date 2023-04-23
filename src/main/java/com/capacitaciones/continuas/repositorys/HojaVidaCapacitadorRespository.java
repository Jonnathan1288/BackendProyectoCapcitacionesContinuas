package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.HojaVidaCapacitador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HojaVidaCapacitadorRespository extends JpaRepository<HojaVidaCapacitador, Integer> {
}

