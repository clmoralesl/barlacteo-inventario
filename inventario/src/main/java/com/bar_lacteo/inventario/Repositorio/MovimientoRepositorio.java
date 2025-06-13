package com.bar_lacteo.inventario.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bar_lacteo.inventario.Modelo.Movimiento;

public interface MovimientoRepositorio extends JpaRepository<Movimiento, Long> {
    
}
