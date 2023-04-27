package com.capacitaciones.continuas.repositorys;


import models.Programas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramasRepository extends JpaRepository<Programas , Integer> {
}
