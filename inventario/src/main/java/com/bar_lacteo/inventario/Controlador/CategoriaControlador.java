package com.bar_lacteo.inventario.Controlador;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;

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

import com.bar_lacteo.inventario.Modelo.Categoria;
import com.bar_lacteo.inventario.Repositorio.CategoriaRepositorio;
import com.bar_lacteo.inventario.Servicio.CategoriaServicio;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaControlador {

    private final CategoriaRepositorio categoriaRepositorio;
    private final CategoriaServicio categoriaServicio;

    public CategoriaControlador(CategoriaRepositorio categoriaRepositorio, CategoriaServicio categoriaServicio) {
    this.categoriaRepositorio = categoriaRepositorio;
    this.categoriaServicio = categoriaServicio;
}

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarCategoria(@RequestParam String nombreCategoria) {
        try {
            Categoria nuevaCategoria = categoriaServicio.registrar(nombreCategoria);
            return ResponseEntity.ok(nuevaCategoria);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping
    public List<Categoria> listarCategoria() {
        return categoriaRepositorio.findAll();
        
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
            return ResponseEntity.ok(categoriaActualizada);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }  

    
}
