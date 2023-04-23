package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.Silabo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SilaboRepository extends JpaRepository<Silabo, Integer> {
}
