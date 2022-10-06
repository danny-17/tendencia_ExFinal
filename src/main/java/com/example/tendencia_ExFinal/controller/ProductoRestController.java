package com.example.tendencia_ExFinal.controller;

import com.example.tendencia_ExFinal.model.Producto;
import com.example.tendencia_ExFinal.service.ProductoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoRestController {

    @Autowired
    ProductoServiceImp productoS;

    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listar() {
        return new ResponseEntity<>(productoS.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Producto> crear(@RequestBody Producto p) {
        HttpHeaders responseHeaders = new HttpHeaders();
        if (p.getNombreP().isEmpty()){
            responseHeaders.set("ERROR","CANTIDAD");
        }
        return new ResponseEntity<>(productoS.crear(p), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Producto> eliminar(@PathVariable Long id) {
        productoS.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id, @RequestBody Producto p) {
        Producto producto = productoS.findById(id);
        if (producto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                producto.setCod_producto(p.getCod_producto());
                producto.setNombreP(p.getNombreP());
                producto.setPrecio(p.getPrecio());
                producto.setCantidad(p.getCantidad());
                return new ResponseEntity<>(productoS.crear(p), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
