package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.Area;
import com.capacitaciones.continuas.Modelos.Primary.Parroquia;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParroquiaRepository extends GenericRepository<Parroquia, Integer> {
    public List<Parroquia> findByCanton_IdCanton(Integer idCanton);
}
