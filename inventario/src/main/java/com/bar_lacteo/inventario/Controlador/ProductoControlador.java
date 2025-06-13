package com.bar_lacteo.inventario.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.bar_lacteo.inventario.Modelo.Producto;
import com.bar_lacteo.inventario.Producto.ProductoDTO;
import com.bar_lacteo.inventario.Producto.ProductoModeloAssembler;
import com.bar_lacteo.inventario.Repositorio.ProductoRepositorio;
import com.bar_lacteo.inventario.Servicio.ProductoServicio;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/producto")
public class ProductoControlador {

    private final ProductoRepositorio productoRepositorio;

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private ProductoModeloAssembler assembler;

    public ProductoControlador(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    @GetMapping
    public CollectionModel<EntityModel<ProductoDTO>> listarProductos() {
        List<EntityModel<ProductoDTO>> productos = productoServicio.listarProductos().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(productos,
                linkTo(methodOn(ProductoControlador.class).listarProductos()).withSelfRel());
    }

    @GetMapping("/stock_bajo")
    public CollectionModel<EntityModel<ProductoDTO>> productoStockBajo() {
        List<EntityModel<ProductoDTO>> productos = productoServicio.productoBajoStock().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(productos,
                linkTo(methodOn(ProductoControlador.class).productoStockBajo()).withSelfRel());
    }

    @GetMapping("/{codigoBarra}")
    public EntityModel<ProductoDTO> obtenerProductoPorCodigo(@PathVariable Integer codigoBarra) {
        ProductoDTO producto = productoServicio.listarProductos().stream()
                .filter(p -> p.getCodBarra().equals(codigoBarra))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
        return assembler.toModel(producto);
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

    @DeleteMapping("/{codigoBarra}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Integer codigoBarra) {
        try {
            productoServicio.eliminarProducto(codigoBarra);
            return ResponseEntity.ok("Producto eliminado exitosamente");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{codigoBarra}")
    public ResponseEntity<?> modificarProducto(
            @PathVariable Integer codigoBarra,
            @Valid @RequestBody Producto productoActualizado) {
        try {
            if (!codigoBarra.equals(productoActualizado.getCodigoBarra())) {
                return ResponseEntity.badRequest()
                        .body("El código de barra en la URL no coincide con el del producto");
            }

            Producto productoModificado = productoServicio.actualizarProducto(codigoBarra, productoActualizado);
            return ResponseEntity.ok(productoModificado);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Producto con código de barra " + codigoBarra + " no encontrado");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al modificar el producto: " + e.getMessage());
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