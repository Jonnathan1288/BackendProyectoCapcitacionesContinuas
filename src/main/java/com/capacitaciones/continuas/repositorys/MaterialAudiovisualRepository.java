package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.MaterialAudiovisual;
import com.capacitaciones.continuas.models.MaterialConvencional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialAudiovisualRepository extends JpaRepository<MaterialAudiovisual, Integer> {
}
