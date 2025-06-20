package com.bar_lacteo.inventario.Controlador;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bar_lacteo.inventario.Assembler.ProveedorModelAssembler;
import com.bar_lacteo.inventario.Modelo.Proveedor;
import com.bar_lacteo.inventario.Servicio.ProveedorServicio;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Proveedor", description = "Controlador para gestionar proveedores")

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorControlador {

    private final ProveedorServicio service;
    private final ProveedorModelAssembler assembler;

    public ProveedorControlador(ProveedorServicio service, ProveedorModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping
    public CollectionModel<EntityModel<Proveedor>> listar() {
        List<EntityModel<Proveedor>> proveedores = service.listar().stream()
            .map(assembler::toModel)
            .toList();

        return CollectionModel.of(proveedores,
            linkTo(methodOn(ProveedorControlador.class).listar()).withSelfRel());
    }

    @PostMapping
    public ResponseEntity<?> guardar(@Valid @RequestBody Proveedor proveedor) {
        try {
            Proveedor nuevo = service.guardar(proveedor);
            return ResponseEntity
                .created(linkTo(methodOn(ProveedorControlador.class).buscar(nuevo.getId())).toUri())
                .body(assembler.toModel(nuevo));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        Proveedor proveedor = service.buscarPorId(id);
        if (proveedor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Proveedor no encontrado");
        }
        return ResponseEntity.ok(assembler.toModel(proveedor));
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<?> buscarPorRut(@PathVariable Integer rut) {
        try {
            Proveedor proveedor = service.buscarPorRut(rut);
            return ResponseEntity.ok(assembler.toModel(proveedor));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @Valid @RequestBody Proveedor proveedor) {
        try {
            Proveedor actualizado = service.actualizar(id, proveedor);
            return ResponseEntity.ok(assembler.toModel(actualizado));
        } catch (IllegalArgumentException e) {
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
