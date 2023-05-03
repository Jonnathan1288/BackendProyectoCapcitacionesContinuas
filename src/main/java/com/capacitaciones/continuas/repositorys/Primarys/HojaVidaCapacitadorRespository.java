package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.HojaVidaCapacitador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HojaVidaCapacitadorRespository extends JpaRepository<HojaVidaCapacitador, Integer> {

    HojaVidaCapacitador findByCapacitadorUsuarioIdUsuario(Integer idUsuario);
}

