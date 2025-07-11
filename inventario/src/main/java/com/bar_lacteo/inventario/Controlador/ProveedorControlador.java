package com.bar_lacteo.inventario.Controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bar_lacteo.inventario.Modelo.Proveedor;
import com.bar_lacteo.inventario.Servicio.ProveedorServicio;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/proveedor")
public class ProveedorControlador {

    private final ProveedorServicio service;

    public ProveedorControlador(ProveedorServicio service) {
        this.service = service;
    }

    @GetMapping
    public List<Proveedor> listar() {
        return service.listar();
    }


    @PostMapping
    public ResponseEntity<?> guardar(@Valid @RequestBody Proveedor proveedor) {
    try {
        Proveedor nuevo = service.guardar(proveedor);
        return ResponseEntity.ok(nuevo);
    } catch (IllegalStateException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
}

    @GetMapping("/{id}")
    public Proveedor buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
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
