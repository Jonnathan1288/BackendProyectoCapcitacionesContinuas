package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Capacitador;
import com.capacitaciones.continuas.Modelos.Primary.Usuario;
import com.capacitaciones.continuas.controllers.generic.GenericControllerImpl;
import com.capacitaciones.continuas.services.UsuarioService;
import com.capacitaciones.continuas.services.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "https://apps.tecazuay.edu.ec" })
@RestController
@RequestMapping("/edc/api/usuario")
public class UsuarioController extends GenericControllerImpl<Usuario, Integer> {

    private UsuarioService usuarioService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, PasswordEncoder passwordEncoder){
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected GenericService<Usuario, Integer> getService() {
        return usuarioService;
    }


    @PostMapping("/crear")
    public ResponseEntity<Usuario> crear(@RequestBody Usuario c) {
        try {
            c.setEstadoUsuarioActivo(true);
            return new ResponseEntity<>(usuarioService.save(c), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findbyCedula/{cedula}")
    public ResponseEntity<?> findbyCedula(@PathVariable("cedula") String cedula){
        try {
            Usuario nc = usuarioService.findByPersonaIdentificacion(cedula);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("USUARIO NO ENCONTRADO",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        try {

            Usuario usuario1 = usuarioService.findById(id);
            if(usuario1 != null){
                usuario1.setUsername(usuario.getUsername());
                usuario1.setEstadoUsuarioActivo(usuario.getEstadoUsuarioActivo());
                usuario1.setFotoPerfil(usuario.getFotoPerfil());

                if(usuario.getPassword().equals(usuario1.getPassword())){
                    usuario1.setPassword(usuario.getPassword());
                    System.out.println("igual");
                }else{
                    System.out.println("difetene");
                    usuario1.setPassword(passwordEncoder.encode(usuario.getPassword()));
                }
                usuario1.setRoles(usuario.getRoles());

                return new ResponseEntity<>(usuarioService.save(usuario1), HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updatePictureUser/{idUser}/{picture}")
    public Integer updatePictureUser(@PathVariable("idUser") Integer idUser, @PathVariable("picture") String picture) {
        return usuarioService.updatePictureUser(idUser, picture);
    }

}
