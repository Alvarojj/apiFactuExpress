package com.FacutraExpress.apiFactura.Models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class FacturasSalidaDto {
    private int id;
    private int nit;
    private String departamento;
    private String direccion;
    private String municipio;
    private String razon;
    private String telefono;
    private List<Factura> factura;
}
