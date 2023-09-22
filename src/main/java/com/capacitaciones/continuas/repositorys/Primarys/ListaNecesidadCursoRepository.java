package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.ListaNecesidadCurso;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaNecesidadCursoRepository extends GenericRepository<ListaNecesidadCurso, Integer> {
    public List<ListaNecesidadCurso> findByNecesidadCurso_IdNecesidadCurso(Integer idNecesidad);
}
