package com.bar_lacteo.inventario.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoControlador {
    private final ProductoRepositorio productoRepositorio;

    @Autowired
    private ProductoServicio productoServicio;

    ProductoControlador(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarProducto(@RequestBody Producto producto) {
         try {
            Producto productoGuardado = productoServicio.crearProducto(producto);
            return ResponseEntity.ok(productoGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al registrar el producto: " + e.getMessage());
        }
    }
}