package com.FacutraExpress.apiFactura.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    private String correo;
    private String departamento;
    private String direccion;
    @Column(name = "fecha_nacimiento")
    private Date fecha;
    private String municipio;
    private String nombre;
    private String telefono;

}
