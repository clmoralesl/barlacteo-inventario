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
        // Validar campos obligatorios
        if (producto == null || 
            producto.getNombreProducto() == null || 
            producto.getNombreProducto().trim().isBlank()) {
            return ResponseEntity.badRequest().body("El nombre del producto no puede estar vacío");
        }
        if (producto.getPrecioUnitario() == null || producto.getPrecioUnitario() <= 0) {
            return ResponseEntity.badRequest().body("El precio unitario debe ser mayor que cero");
        }
        if (producto.getCategoria() == null || producto.getCategoria().getIdCategoria() == null) {
            return ResponseEntity.badRequest().body("La categoría es obligatoria");
        }

        // Verificar si ya existe un producto con el mismo nombre

        // Crear nuevo producto
        Producto nuevoProducto = new Producto();
        nuevoProducto.setCodigoBarra(producto.getCodigoBarra());
        nuevoProducto.setNombreProducto(producto.getNombreProducto().trim());
        nuevoProducto.setDescripcion(producto.getDescripcion() != null ? producto.getDescripcion().trim() : null);
        nuevoProducto.setPrecioUnitario(producto.getPrecioUnitario());
        nuevoProducto.setStockMinimo(producto.getStockMinimo());
        nuevoProducto.setCategoria(producto.getCategoria());

        try {
            Producto productoGuardado = productoServicio.crearProducto(nuevoProducto);
            return ResponseEntity.ok(productoGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al registrar el producto: " + e.getMessage());
        }
    }
}