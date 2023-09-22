package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.Capacitador;
import com.capacitaciones.continuas.repositorys.Primarys.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapacitadorRepository extends GenericRepository<Capacitador, Integer> {
    public Capacitador findByUsuarioIdUsuario(Integer idUsuario);

    public Boolean existsByUsuarioIdUsuario(Integer idUsuario);
}

