package com.example.tendencia_ExFinal.service;

import com.example.tendencia_ExFinal.model.Cliente;

import java.util.List;

public interface ClienteService {
    public List<Cliente> findByAll();

    public Cliente crear(Cliente cliente);

    public Cliente findById(Long id);

    public void delete(Long id);
}
