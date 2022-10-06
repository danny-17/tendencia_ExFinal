package com.example.tendencia_ExFinal.service;

import com.example.tendencia_ExFinal.model.Producto;
import com.example.tendencia_ExFinal.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImp implements ProductoService{

    @Autowired
    ProductoRepository productoR;

    @Override
    public List<Producto> findByAll() {
        return productoR.findAll();
    }

    @Override
    public Producto crear(Producto producto) {
        return productoR.save(producto);
    }

    @Override
    public Producto findById(Long id) {
        return productoR.findById(id).orElse(new Producto());
    }

    @Override
    public void delete(Long id) {
        productoR.deleteById(id);
    }
}
