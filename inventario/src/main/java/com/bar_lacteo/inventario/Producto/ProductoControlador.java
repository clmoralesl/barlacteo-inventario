package com.bar_lacteo.inventario.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<?> registrarProducto(@Valid @RequestBody Producto producto) {
         try {
            Producto productoGuardado = productoServicio.crearProducto(producto);
            return ResponseEntity.ok(productoGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al registrar el producto: " + e.getMessage());
        }
    }

    @GetMapping
    public List<Producto> mostrarProductos(){
        return productoRepositorio.findAll();
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarProductos(){
        try {
            List<ProductoDTO> productos = productoServicio.listarProductos();
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{codigoBarra}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Integer codigoBarra){
        try{
            productoServicio.eliminarProducto(codigoBarra);
            return ResponseEntity.ok("Producto eliminado exitósamente");
        }catch(EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(errors);
    }
}