package com.example.tendencia_ExFinal.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "factura")
@Data
@AllArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "id_cliente")
    private int id_cliente;
    @Column(name = "factura")
    private int num_factura;
    @Column(name = "fecha")
    private Date fecha;

    public Factura() {

    }
}
