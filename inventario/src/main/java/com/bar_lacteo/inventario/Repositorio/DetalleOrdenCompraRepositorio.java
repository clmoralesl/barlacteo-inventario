package com.bar_lacteo.inventario.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bar_lacteo.inventario.Modelo.DetalleOrdenCompra;

public interface DetalleOrdenCompraRepositorio extends JpaRepository<DetalleOrdenCompra, Long>{
    
}
