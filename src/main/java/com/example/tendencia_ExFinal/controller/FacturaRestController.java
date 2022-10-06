package com.example.tendencia_ExFinal.controller;

import com.example.tendencia_ExFinal.model.Factura;
import com.example.tendencia_ExFinal.service.FacturaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factura")
public class FacturaRestController {

    @Autowired
    FacturaServiceImp facturaS;

    @GetMapping("/listar")
    public ResponseEntity<List<Factura>> listar() {
        return new ResponseEntity<>(facturaS.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Factura> crear(@RequestBody Factura f) {
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(facturaS.crear(f), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Factura> eliminar(@PathVariable Long id) {
        facturaS.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Factura> actualizar(@PathVariable Long id, @RequestBody Factura f) {
        Factura factura = facturaS.findById(id);
        if (factura == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                factura.setNum_factura(f.getNum_factura());
                factura.setFecha(f.getFecha());
                return new ResponseEntity<>(facturaS.crear(f), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
