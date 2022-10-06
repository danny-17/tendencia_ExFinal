package com.example.tendencia_ExFinal.service;

import com.example.tendencia_ExFinal.model.Factura;

import java.util.List;

public interface FacturaService {
    public List<Factura> findByAll();

    public Factura crear(Factura factura);

    public Factura findById(Long id);

    public void delete(Long id);
}
