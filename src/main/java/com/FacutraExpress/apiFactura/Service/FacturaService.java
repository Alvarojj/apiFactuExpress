package com.FacutraExpress.apiFactura.Service;

import com.FacutraExpress.apiFactura.Models.Factura;
import com.FacutraExpress.apiFactura.Models.FacturasSalidaDto;
import com.FacutraExpress.apiFactura.Repository.FacturaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    public List<FacturasSalidaDto> obtenerFacturaPorFecha(int idUsuario, String fecha) {
        List<FacturasSalidaDto> facturasSalidaDtos = new ArrayList<>();
        List<Factura> facturas = facturaRepository.obtenerFacturaIdUsuarioAndFecha(idUsuario, fecha);
        for (Factura factura: facturas) {
            facturasSalidaDtos = tranformadorFacturaSalida(factura, facturasSalidaDtos);
        }

        return facturasSalidaDtos;
    }


    private List<FacturasSalidaDto> tranformadorFacturaSalida(Factura factura, List<FacturasSalidaDto> facturasSalidaDtos) {
        long count = facturasSalidaDtos.stream().filter(x -> x.getId() == factura.getComercio().getId()).count();
        if (count == 0) {
            FacturasSalidaDto newfacturas = FacturasSalidaDto.builder()
                    .id(factura.getComercio().getId())
                    .nit(factura.getComercio().getNit())
                    .razon(factura.getComercio().getRazon())
                    .departamento(factura.getComercio().getDepartamento())
                    .direccion(factura.getComercio().getDireccion())
                    .municipio(factura.getComercio().getMunicipio())
                    .telefono(factura.getComercio().getTelefono())
                    .factura(new ArrayList<>()).build();
            newfacturas.getFactura().add(factura);
            facturasSalidaDtos.add(newfacturas);
        } else {
            for (FacturasSalidaDto facturasSalidaDto : facturasSalidaDtos) {
                if (facturasSalidaDto.getId() == factura.getComercio().getId()) {
                    facturasSalidaDto.getFactura().add(factura);
                }
            }
        }
        return facturasSalidaDtos;
    }
}
