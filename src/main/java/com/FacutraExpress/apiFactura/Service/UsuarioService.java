package com.FacutraExpress.apiFactura.Service;

import com.FacutraExpress.apiFactura.Models.Factura;
import com.FacutraExpress.apiFactura.Models.Usuario;
import com.FacutraExpress.apiFactura.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final FacturaService facturaService;

    public UsuarioService(UsuarioRepository usuarioRepository, FacturaService facturaService) {
        this.usuarioRepository = usuarioRepository;
        this.facturaService = facturaService;
    }

    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
    public Usuario obtenerUsuarioPorCorreo(String correo) {
       return usuarioRepository.findByCorreo(correo);
    }

    public Usuario obtenerInfoUsuario(int idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }


    public int ObtenerAhorro(int idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario);
        return usuario.getAhorroPapel();
    }

}
