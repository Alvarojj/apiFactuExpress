package com.FacutraExpress.apiFactura.Service;

import com.FacutraExpress.apiFactura.Models.Factura;
import com.FacutraExpress.apiFactura.Repository.FacturaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FacturaService {

    private final FacturaRepository facturaRepository;

    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    public List<Factura> obtenerFactura(int idUsuario) {
        return facturaRepository.obtenerFacturaIdUsuario(idUsuario);

    }


    public List<Factura> obtenerFacturaPorFecha(int idUsuario, String fecha) {
        return facturaRepository.obtenerFacturaIdUsuarioAndFecha(idUsuario, fecha);
    }
}
