package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.MaterialAudiovisual;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialAudiovisualRepository extends GenericRepository<MaterialAudiovisual, Integer> {

    List<MaterialAudiovisual> findBySilaboIdSilabo(Integer idSilabo);

}
