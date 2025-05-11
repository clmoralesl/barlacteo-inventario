package com.bar_lacteo.inventario.Movimiento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepositorio  extends JpaRepository<Movimiento, Long > {
    
}
