package com.bar_lacteo.inventario.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bar_lacteo.inventario.Assembler.CategoriaModeloAssembler;
import com.bar_lacteo.inventario.Modelo.Categoria;
import com.bar_lacteo.inventario.Repositorio.CategoriaRepositorio;
import com.bar_lacteo.inventario.Servicio.CategoriaServicio;
import io.swagger.v3.oas.annotations.tags.Tag;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
@Tag(name = "Categoría", description = "Controlador para gestionar categorías del inventario")
@RestController
@RequestMapping("/api/categoria")
public class CategoriaControlador {

    
    private final CategoriaRepositorio categoriaRepositorio;
    private final CategoriaServicio categoriaServicio;

    @Autowired
    private CategoriaModeloAssembler assembler;

    public CategoriaControlador(CategoriaRepositorio categoriaRepositorio, CategoriaServicio categoriaServicio) {
        this.categoriaRepositorio = categoriaRepositorio;
        this.categoriaServicio = categoriaServicio;
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarCategoria(@RequestParam String nombreCategoria) {
        try {
            Categoria nuevaCategoria = categoriaServicio.registrar(nombreCategoria);
                return ResponseEntity.ok(assembler.toModel(nuevaCategoria));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping
    public CollectionModel<EntityModel<Categoria>> listarCategoria() {
        List<EntityModel<Categoria>> categorias = categoriaRepositorio.findAll().stream()
            .map(categoria -> EntityModel.of(categoria,
                    linkTo(methodOn(CategoriaControlador.class).listarCategoria()).withSelfRel(),
                    linkTo(methodOn(CategoriaControlador.class).eliminarCategoria(categoria.getIdCategoria())).withRel("eliminar"),
                    linkTo(methodOn(CategoriaControlador.class).actualizarCategoria(
                        categoria.getIdCategoria(), categoria.getNombreCategoria())).withRel("actualizar")
            ))
            .toList();

        return CollectionModel.of(categorias,
                linkTo(methodOn(CategoriaControlador.class).listarCategoria()).withSelfRel());
    } 

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerCategoria(@PathVariable Integer id) {
        return categoriaRepositorio.findById(id)
            .<ResponseEntity<?>>map(categoria -> ResponseEntity.ok(assembler.toModel(categoria)))
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoría no encontrada"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable Integer id) {
        try {
            categoriaServicio.eliminarCategoria(id);
            return ResponseEntity.ok("Categoría eliminada con éxito");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCategoria(
            @PathVariable Integer id,
            @RequestParam String nuevoNombre) {
        try {
            Categoria categoriaActualizada = categoriaServicio.actualizarNombre(id, nuevoNombre);
            return ResponseEntity.ok(assembler.toModel(categoriaActualizada));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }  
}
