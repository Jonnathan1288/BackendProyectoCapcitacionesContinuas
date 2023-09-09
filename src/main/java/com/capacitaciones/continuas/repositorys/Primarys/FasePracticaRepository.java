package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.FasePractica;

import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FasePracticaRepository extends GenericRepository<FasePractica, Integer> {

    @Query("SELECT ft FROM FasePractica ft WHERE ft.disenioCurricular.idDisenioCurricular = :disenioCurricularId")
    List<FasePractica> findAllByDisenioCurricularId(Integer disenioCurricularId);

}
