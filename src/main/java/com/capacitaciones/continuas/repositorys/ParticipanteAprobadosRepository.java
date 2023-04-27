package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.ParticipantesAprobados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipanteAprobadosRepository extends JpaRepository<ParticipantesAprobados, Integer> {
}

