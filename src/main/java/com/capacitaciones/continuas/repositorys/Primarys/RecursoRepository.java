package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.Instalacion;
import com.capacitaciones.continuas.Modelos.Primary.Recurso;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoRepository extends GenericRepository<Recurso, Integer> {

}
