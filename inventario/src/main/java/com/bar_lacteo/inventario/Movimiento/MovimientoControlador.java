package com.bar_lacteo.inventario.Movimiento;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoControlador {

    private final MovimientoServicio movimientoServicio;

    public MovimientoControlador(MovimientoServicio movimientoServicio){
        this.movimientoServicio = movimientoServicio;
    }

    @GetMapping
    public List<Movimiento> listar(){
        return movimientoServicio.listarMovimientos();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id){
        boolean eliminado = movimientoServicio.eliminarMovimiento(id);
        if (eliminado){
            return ResponseEntity.ok("Movimiento elimano satisfactoriamente");
        } else {
        return ResponseEntity.notFound().build();
        }
    }
    
}
