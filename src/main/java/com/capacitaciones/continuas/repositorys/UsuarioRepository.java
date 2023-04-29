package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findByUsernameAndPassword(String username, String password);
}
