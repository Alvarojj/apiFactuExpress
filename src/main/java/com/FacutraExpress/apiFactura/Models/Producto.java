package com.FacutraExpress.apiFactura.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cantidad;
    private String nombre;
    private double total;
    @JoinColumn(name = "total_iva")
    private double totalIva;
    @ManyToOne
    @JoinColumn(name = "idFactura")
    private Factura factura;
}
