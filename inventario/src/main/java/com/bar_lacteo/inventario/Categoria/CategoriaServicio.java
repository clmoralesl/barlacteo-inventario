package com.bar_lacteo.inventario.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServicio {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    public Categoria crearCategoria(Categoria categoria){
        return categoriaRepositorio.save(categoria);
    }
    
}
