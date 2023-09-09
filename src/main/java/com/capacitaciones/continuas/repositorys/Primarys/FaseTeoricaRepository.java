package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.FaseTeorica;
import com.capacitaciones.continuas.Modelos.Primary.Instalacion;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaseTeoricaRepository extends GenericRepository<FaseTeorica, Integer> {

    @Query("SELECT ft FROM FaseTeorica ft WHERE ft.disenioCurricular.idDisenioCurricular = :disenioCurricularId")
    List<FaseTeorica> findAllByDisenioCurricularId(Integer disenioCurricularId);
}
