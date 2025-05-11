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
@RequestMapping("/api/producto")
public class ProductoControlador {

    private final ProductoRepositorio productoRepositorio;
    private final ProductoServicio productoServicio;

    @Autowired
    public ProductoControlador(ProductoRepositorio productoRepositorio,
     ProductoServicio productoServicio) {
        this.productoRepositorio = productoRepositorio;
        this.productoServicio = productoServicio;
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
    public List<Producto> listarProductos(){
        return productoRepositorio.findAll();
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