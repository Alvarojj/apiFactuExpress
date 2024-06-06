package com.FacutraExpress.apiFactura.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String apellido;
    private String cedula;
    private String clave;
    private String correo;
    private String departamento;
    private String direccion;
    private Date fecha;
    private String municipio;
    private String nombre;
    private String telefono;

}
