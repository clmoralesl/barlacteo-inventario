package com.bar_lacteo.inventario.Categoria;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria,Integer>{

    Optional<Categoria> findByNombreCategoria(String nombre);
    
}
