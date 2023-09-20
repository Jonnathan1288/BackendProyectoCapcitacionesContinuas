package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.Canton;
import com.capacitaciones.continuas.Modelos.Primary.Parroquia;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CantonRepository extends GenericRepository<Canton, Integer> {
    public List<Canton> findByProvinciaIdProvincia(Integer idProvincia);
}
