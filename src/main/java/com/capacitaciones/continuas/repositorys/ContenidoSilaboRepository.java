package com.capacitaciones.continuas.repositorys;


import com.capacitaciones.continuas.models.ContenidoSilabo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContenidoSilaboRepository extends JpaRepository<ContenidoSilabo, Integer> {

    List<ContenidoSilabo> findBySilaboIdSilabo(Integer idSilabo);

}
