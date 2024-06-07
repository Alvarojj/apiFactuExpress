package com.FacutraExpress.apiFactura.Controllers;

import com.FacutraExpress.apiFactura.Models.Usuario;
import com.FacutraExpress.apiFactura.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping("{id}")
    public ResponseEntity<Usuario> obtenerInfoUsuario(@PathVariable int id) {
        Optional<Usuario> usuario = usuarioService.obtenerInfoUsuario(id);
        return usuario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("ahorro/{id}")
    public ResponseEntity<Double> ObtenerAhorro(@PathVariable int id) {
        return new ResponseEntity<>(usuarioService.ObtenerAhorro(id), HttpStatus.OK);
    }
}
