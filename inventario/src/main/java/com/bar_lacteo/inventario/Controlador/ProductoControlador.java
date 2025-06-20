package com.bar_lacteo.inventario.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.hateoas.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.bar_lacteo.inventario.Assembler.ProductoEntidadModeloAssembler;
import com.bar_lacteo.inventario.Assembler.ProductoModeloAssembler;
import com.bar_lacteo.inventario.DTO.ProductoDTO;
import com.bar_lacteo.inventario.Modelo.Producto;
import com.bar_lacteo.inventario.Repositorio.ProductoRepositorio;
import com.bar_lacteo.inventario.Servicio.ProductoServicio;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
@Tag(name = "Producto", description = "Controlador para gestionar productos del inventario")
@RestController
@RequestMapping("/api/producto")
public class ProductoControlador {

    private final ProductoRepositorio productoRepositorio;

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private ProductoModeloAssembler assembler;

    @Autowired
    private ProductoEntidadModeloAssembler productoEntidadAssembler;

    public ProductoControlador(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    @GetMapping(produces = "application/json; charset=UTF-8")
    public CollectionModel<EntityModel<Producto>> mostrarProductos() {
        List<EntityModel<Producto>> productos = productoRepositorio.findAll().stream()
            .map(productoEntidadAssembler::toModel)
            .toList();

        return CollectionModel.of(productos,
            linkTo(methodOn(ProductoControlador.class).mostrarProductos()).withSelfRel());
    }

    @GetMapping("/listar")
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
            EntityModel<Producto> productoModel = productoEntidadAssembler.toModel(productoGuardado);
            return ResponseEntity.status(HttpStatus.CREATED).body(productoModel);
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
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Error al eliminar, producto se encuentra asociado a un lote o movimiento");
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
            EntityModel<Producto> productoModel = productoEntidadAssembler.toModel(productoModificado);
            return ResponseEntity.ok(productoModel);
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


    @GetMapping("/buscar-nombre")
    public CollectionModel<EntityModel<ProductoDTO>> buscarPorNombreNativo(@RequestParam String nombre) {
        List<ProductoDTO> encontrados = productoServicio.buscarPorNombreParcialNativo(nombre);

        List<EntityModel<ProductoDTO>> productos = encontrados.stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(productos,
                linkTo(methodOn(ProductoControlador.class).buscarPorNombreNativo(nombre)).withSelfRel());
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