package com.FacutraExpress.apiFactura.Controllers;

import com.FacutraExpress.apiFactura.Models.Factura;
import com.FacutraExpress.apiFactura.Service.FacturaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("factura")
public class FacturaController {
    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }


    @GetMapping("{id}")
    public List<Factura> obteneFactura(@PathVariable int id){
        return facturaService.obtenerFactura(id);
    }
}
