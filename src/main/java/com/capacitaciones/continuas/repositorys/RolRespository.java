package com.capacitaciones.continuas.repositorys;

import models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRespository extends JpaRepository<Rol, Integer> {
}