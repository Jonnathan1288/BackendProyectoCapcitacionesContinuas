package com.capacitaciones.continuas.repositorys;

import com.capacitaciones.continuas.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
