package com.bar_lacteo.inventario.Servicio;

import com.bar_lacteo.inventario.Modelo.Movimiento;
import com.bar_lacteo.inventario.Repositorio.MovimientoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class MovimientoServicio {

    @Autowired
    private MovimientoRepositorio movimientoRepositorio;

    @Transactional
    public Movimiento registrarMovimiento(Movimiento movimiento) {
        movimiento.setFechaMovimiento(LocalDateTime.now());
        return movimientoRepositorio.save(movimiento);
    }
}
