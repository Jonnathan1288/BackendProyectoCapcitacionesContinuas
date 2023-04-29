package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.Inscrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscritoRepository extends JpaRepository<Inscrito, Integer> {
    List<Inscrito> findByCursoIdCurso(Integer idCurso);

}
