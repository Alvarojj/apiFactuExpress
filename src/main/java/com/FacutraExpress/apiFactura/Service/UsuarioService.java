package com.FacutraExpress.apiFactura.Service;

import com.FacutraExpress.apiFactura.Models.Usuario;
import com.FacutraExpress.apiFactura.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Usuario> obtenerInfoUsuario(int idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }
}
