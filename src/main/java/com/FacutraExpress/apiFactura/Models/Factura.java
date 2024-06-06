package com.FacutraExpress.apiFactura.Models;

import jakarta.persistence.*;
import lombok.*;
import com.FacutraExpress.apiFactura.Models.Comercio;

import java.util.Date;
import java.util.List;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date fecha;
    private double iva;
    @JoinColumn(name = "numero_factura")
    private int numeroFactura;
    private double subtotal;
    private double total;
    @ManyToOne
    @JoinColumn(name = "idcomercio")
    private Comercio comercio;
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;
    @OneToMany(mappedBy = "factura")
    private List<Producto> productos;

}
