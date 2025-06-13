package com.bar_lacteo.inventario.Repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bar_lacteo.inventario.Modelo.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria,Integer>{

    Optional<Categoria> findByNombreCategoria(String nombre);
    
}
