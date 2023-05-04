package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.ParticipantesAprobados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipanteAprobadosRepository extends JpaRepository<ParticipantesAprobados, Integer> {
}

