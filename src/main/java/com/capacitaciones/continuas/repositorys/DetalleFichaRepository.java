package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.DetalleFichaMatricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleFichaRepository extends JpaRepository<DetalleFichaMatricula, Integer> {

    public DetalleFichaMatricula findByFichaMatriculaInscritoUsuarioIdUsuario(Integer idUsuario);
}
