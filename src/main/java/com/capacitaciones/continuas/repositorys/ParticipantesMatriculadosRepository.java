package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.PartipantesMatriculados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantesMatriculadosRepository extends JpaRepository<PartipantesMatriculados, Integer> {
}
