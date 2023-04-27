package com.capacitaciones.continuas.repositorys;


import models.ContenidoSilabo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContenidoSilaboRepository extends JpaRepository<ContenidoSilabo, Integer> {
}
