package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.models.Usuario;
import com.capacitaciones.continuas.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class OauthController {
    @Autowired
    private UsuarioService usuarioService;


   @GetMapping("/signIn/getaccount/{username}/{password}")
    public ResponseEntity<Usuario> login(@PathVariable("username") String username, @PathVariable("password") String password) {
       try {
           Usuario usuario = usuarioService.findByUsernameAndPassword(username, password);
           if(usuario != null){
               return new ResponseEntity<>(usuario, HttpStatus.OK);
           }
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }catch (Exception e){
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

       }
    }
}
