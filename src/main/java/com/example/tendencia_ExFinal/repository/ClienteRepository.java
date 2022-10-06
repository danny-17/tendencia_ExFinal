package com.example.tendencia_ExFinal.repository;

import com.example.tendencia_ExFinal.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
