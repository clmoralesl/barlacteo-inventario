package com.bar_lacteo.inventario.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bar_lacteo.inventario.Modelo.Lote;

public interface LoteRepositorio extends JpaRepository<Lote, Integer> {

    
}