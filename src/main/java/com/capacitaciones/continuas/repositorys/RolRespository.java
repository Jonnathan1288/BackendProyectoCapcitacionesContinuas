package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRespository extends JpaRepository<Rol, Integer> {
}