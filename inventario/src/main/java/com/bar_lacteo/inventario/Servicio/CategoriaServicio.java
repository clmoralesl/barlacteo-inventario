package com.bar_lacteo.inventario.Servicio;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bar_lacteo.inventario.Modelo.Categoria;
import com.bar_lacteo.inventario.Repositorio.CategoriaRepositorio;
import com.bar_lacteo.inventario.Repositorio.ProductoRepositorio;

import jakarta.transaction.Transactional;

@Service
public class CategoriaServicio {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;
    @Autowired
    private ProductoRepositorio productoRepositorio;

    public Categoria registrar(String nombreCategoria) {
        if (nombreCategoria.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        Optional<Categoria> existente = categoriaRepositorio.findByNombreCategoria(nombreCategoria.trim());
        if (existente.isPresent()) {
            throw new IllegalStateException("Ya existe una categoría con ese nombre");
        }
        Categoria nuevaCategoria = new Categoria(nombreCategoria.trim());
        return categoriaRepositorio.save(nuevaCategoria);
    }

    @Transactional
    public void eliminarCategoria(Integer id) {
        if (!categoriaRepositorio.existsById(id)) {
            throw new IllegalArgumentException("Categoría con ID " + id + " no encontrada");
        }
        if (productoRepositorio.existsByCategoriaIdCategoria(id)) {
            throw new IllegalStateException("No se puede eliminar la categoría porque está asociada a productos");
        }
        categoriaRepositorio.deleteById(id);
    }
}
