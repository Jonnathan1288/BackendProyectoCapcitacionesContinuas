package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Rol;
import com.capacitaciones.continuas.services.generic.GenericService;

public interface RolService extends GenericService<Rol,Integer> {

    Rol findByNombreRol(String nombreRol);
}
