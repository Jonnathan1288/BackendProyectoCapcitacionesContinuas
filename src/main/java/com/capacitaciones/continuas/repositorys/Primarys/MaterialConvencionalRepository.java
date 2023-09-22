package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.MaterialConvencional;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialConvencionalRepository extends GenericRepository<MaterialConvencional, Integer> {

    List<MaterialConvencional> findBySilaboIdSilabo(Integer idSilabo);

}
