package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Secondary.DocenteFenix;
import com.capacitaciones.continuas.services.generic.GenericService;

public interface DocenteFenixService extends GenericService<DocenteFenix,Integer> {
    public DocenteFenix findByAndIdentificacion(String identificasion);
}
