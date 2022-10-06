package com.example.tendencia_ExFinal.repository;

import com.example.tendencia_ExFinal.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
