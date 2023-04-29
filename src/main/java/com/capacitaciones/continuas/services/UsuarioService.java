package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.models.Usuario;

public interface UsuarioService extends GenericService<Usuario,Integer>{
    public Usuario findByUsernameAndPassword(String username, String password);
}
