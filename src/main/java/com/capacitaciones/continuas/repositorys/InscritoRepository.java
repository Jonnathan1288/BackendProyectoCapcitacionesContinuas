package com.capacitaciones.continuas.repositorys;

import models.Inscrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscritoRepository extends JpaRepository<Inscrito, Integer> {
}
