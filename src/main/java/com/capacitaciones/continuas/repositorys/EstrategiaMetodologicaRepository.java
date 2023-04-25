package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.EstrategiasMetodologica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstrategiaMetodologicaRepository extends JpaRepository<EstrategiasMetodologica, Integer> {
}
