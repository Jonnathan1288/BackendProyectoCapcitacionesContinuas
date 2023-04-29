package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.Capacitador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapacitadorRepository extends JpaRepository<Capacitador, Integer> {
    public Capacitador findByUsuarioIdUsuario(Integer idUsuario);
}

