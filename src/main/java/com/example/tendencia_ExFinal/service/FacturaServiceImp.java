package com.example.tendencia_ExFinal.service;

import com.example.tendencia_ExFinal.model.Factura;
import com.example.tendencia_ExFinal.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacturaServiceImp implements FacturaService{

    @Autowired
    FacturaRepository facturaR;

    @Override
    public List<Factura> findByAll() {
        return facturaR.findAll();
    }

    @Override
    public Factura crear(Factura factura) {
        return facturaR.save(factura);
    }

    @Override
    public Factura findById(Long id) {
        return facturaR.findById(id).orElse(new Factura());
    }

    @Override
    public void delete(Long id) {
        facturaR.deleteById(id);
    }
}
