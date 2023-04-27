package com.capacitaciones.continuas.repositorys;

import models.MaterialConvencional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialConvencionalRepository extends JpaRepository<MaterialConvencional, Integer> {
}
