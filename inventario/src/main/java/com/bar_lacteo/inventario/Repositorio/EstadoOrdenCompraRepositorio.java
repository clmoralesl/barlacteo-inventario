package com.bar_lacteo.inventario.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bar_lacteo.inventario.Modelo.EstadoOrdenCompra;

public interface EstadoOrdenCompraRepositorio extends JpaRepository<EstadoOrdenCompra, Long>{
    
}
