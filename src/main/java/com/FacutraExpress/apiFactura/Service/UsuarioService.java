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

    public Optional<Usuario> obtenerInfoUsuario(int idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }


    public double ObtenerAhorro(int idUsuario) {
        List<Factura> facturas = facturaService.obtenerFactura(idUsuario);
        if (!facturas.isEmpty()) {
            double ahorroPorProducto = ahorroPorProducto(facturas);
            double ahorroPorFactura = ahorroPorFactura(facturas);
            return ahorroPorFactura + ahorroPorProducto;
        }
        return 0;
    }



    public double ahorroPorProducto (List<Factura> facturas) {
        double ahorroPorProducto = 0;
        for (Factura factura : facturas) {
            ahorroPorProducto += factura.getProductos().size();
        }
        return ahorroPorProducto;
    }

    public double ahorroPorFactura(List<Factura> facturas) {
        double ahorroPorFactura = 15;
        return ahorroPorFactura * facturas.size();
    }
}
