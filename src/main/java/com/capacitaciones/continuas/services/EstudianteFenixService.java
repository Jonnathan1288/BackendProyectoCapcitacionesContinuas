package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Secondary.EstudianteFenix;
import com.capacitaciones.continuas.services.generic.GenericService;

public interface EstudianteFenixService extends GenericService<EstudianteFenix,Integer> {
    public EstudianteFenix findByAndIdentificacion(String identificasion);
}
