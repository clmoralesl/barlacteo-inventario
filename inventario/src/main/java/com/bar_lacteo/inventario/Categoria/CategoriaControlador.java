package com.bar_lacteo.inventario.Categoria;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaControlador {

    private final CategoriaRepositorio categoriaRepositorio;
    
    @Autowired
    private CategoriaServicio categoriaServicio;

    CategoriaControlador(CategoriaRepositorio categoriaRepositorio) {
        this.categoriaRepositorio = categoriaRepositorio;
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarCategoria(@RequestParam String nombreCategoria){
        if (nombreCategoria.isBlank()) {
            return ResponseEntity.badRequest().body("El nombre no puede estar vacío");
        }

        Optional<Categoria> existente = categoriaRepositorio.findByNombreCategoria(nombreCategoria.trim());
        if (existente.isPresent()) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Ya existe una categoría con ese nombre");
    }
        Categoria nuevaCategoria = new Categoria(nombreCategoria);
        return ResponseEntity.ok(categoriaServicio.crearCategoria(nuevaCategoria));
    }

    @GetMapping
    public List<Categoria> listarCategoria() {
        return categoriaRepositorio.findAll();
        
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable Integer id) {
        if (!categoriaRepositorio.existsById(id)) {
            return ResponseEntity.status(404).body("Categoría no encontrada");
        }

        categoriaRepositorio.deleteById(id);


        return ResponseEntity.ok("Categoría eliminada con éxito");
    }
}
