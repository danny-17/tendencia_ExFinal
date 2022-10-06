package com.example.tendencia_ExFinal.service;

import com.example.tendencia_ExFinal.model.Producto;

import java.util.List;

public interface ProductoService {
    public List<Producto> findByAll();

    public Producto crear(Producto producto);

    public Producto findById(Long id);

    public void delete(Long id);
}
