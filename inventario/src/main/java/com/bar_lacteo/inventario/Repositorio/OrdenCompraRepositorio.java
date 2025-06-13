package com.bar_lacteo.inventario.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bar_lacteo.inventario.Modelo.OrdenCompra;

public interface OrdenCompraRepositorio extends JpaRepository<OrdenCompra, Long> {
}