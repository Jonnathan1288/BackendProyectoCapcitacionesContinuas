package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.EstrategiasMetodologica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstrategiaMetodologicaRepository extends JpaRepository<EstrategiasMetodologica, Integer> {

    List<EstrategiasMetodologica> findBySilaboIdSilabo(Integer idSilabo);

}
