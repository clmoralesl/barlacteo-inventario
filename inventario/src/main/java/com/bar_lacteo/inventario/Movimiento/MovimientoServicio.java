package com.bar_lacteo.inventario.Movimiento;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class MovimientoServicio {
    private final MovimientoRepositorio movimientoRepositorio;

    public MovimientoServicio(MovimientoRepositorio movimientoRepositorio) {
        this.movimientoRepositorio = movimientoRepositorio;
    }
    public Movimiento registrarMovimiento(Movimiento movimiento){
        return movimientoRepositorio.save(movimiento);
    }
    public List <Movimiento> listarMovimientos(){
        return movimientoRepositorio.findAll();
    }
    public boolean eliminarMovimiento(Long id){
        if(movimientoRepositorio.existsById(id)){
           movimientoRepositorio.deleteById(id);;
           return true; 
        } else {}
           return false;
    }
}
