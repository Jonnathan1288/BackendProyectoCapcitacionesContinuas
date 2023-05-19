package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Usuario;

public interface UsuarioService extends GenericService<Usuario,Integer>{
    public Usuario findByUsernameAndPassword(String username, String password);

    public Boolean existsByUsername(String username);

    Usuario findByUsername(String username);
}
