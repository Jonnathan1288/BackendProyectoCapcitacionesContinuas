package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.HojaVidaCapacitador;
import com.capacitaciones.continuas.interfaces.HojaVida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface HojaVidaCapacitadorRespository extends JpaRepository<HojaVidaCapacitador, Integer> {

    public HojaVidaCapacitador findHojaVidaCapacitadorByCapacitador_IdCapacitador(Integer idCapacitador);

    public HojaVidaCapacitador findHojaVidaCapacitadorByCapacitadorUsuarioIdUsuario(Integer iDUsuario);

    HojaVidaCapacitador findByCapacitadorUsuarioIdUsuario(Integer idUsuario);

    @Query("SELECT hv.documento as uriDocument, " +
            "hv.idHojaVida as idHojaVida, " +
            "hv.capacitador.idCapacitador as idCapacitador " +
            "FROM HojaVidaCapacitador hv "+
            "WHERE hv.capacitador.usuario.idUsuario = :id ")
    public HojaVida findHojaVidaByIdUsuario(@RequestParam("id") Integer id);

}

