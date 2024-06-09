package com.FacutraExpress.apiFactura.Controllers;

import com.FacutraExpress.apiFactura.Models.Usuario;
import com.FacutraExpress.apiFactura.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("correo")
    public ResponseEntity<Usuario> obtenerUsuarioPorCorreo(@RequestParam String correo) {
        return new ResponseEntity<>(usuarioService.obtenerUsuarioPorCorreo(correo), HttpStatus.OK);
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



    @PostMapping
    public ResponseEntity<HttpStatus> guardarUsuario(
            @RequestBody Usuario usuario
    ) {
        usuarioService.guardarUsuario(usuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
