package com.example.tendencia_ExFinal.service;

import com.example.tendencia_ExFinal.model.Cliente;
import com.example.tendencia_ExFinal.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService{

    @Autowired
    ClienteRepository clienteR;

    @Override
    public List<Cliente> findByAll() {
        return clienteR.findAll();
    }

    @Override
    public Cliente crear(Cliente cliente) {
        return clienteR.save(cliente);
    }

    @Override
    public Cliente findById(Long id) {
        return clienteR.findById(id).orElse(new Cliente());
    }

    @Override
    public void delete(Long id) {
        clienteR.deleteById(id);
    }
}
