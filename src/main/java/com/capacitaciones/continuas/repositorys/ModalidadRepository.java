package com.capacitaciones.continuas.repositorys;

import models.ModalidadCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalidadRepository extends JpaRepository<ModalidadCurso, Integer> {
}
