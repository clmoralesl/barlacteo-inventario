package com.bar_lacteo.inventario.Categoria;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServicio {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    public Categoria crearCategoria(Categoria categoria){
        return categoriaRepositorio.save(categoria);
    }
    
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
}
