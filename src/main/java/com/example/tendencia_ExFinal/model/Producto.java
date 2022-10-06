package com.example.tendencia_ExFinal.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "producto")
@Data
@AllArgsConstructor

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "id_factura")
    private int id_factura;
    @Column(name = "cod_producto")
    private String cod_producto;
    @Column(name = "producto")
    private String nombreP;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "precio")
    private double precio;

    public Producto() {

    }

}
