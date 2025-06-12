package com.bar_lacteo.inventario.Controlador;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bar_lacteo.inventario.Exception.ResourceNotFoundException;
import com.bar_lacteo.inventario.Modelo.Movimiento;
import com.bar_lacteo.inventario.Repositorio.MovimientoRepositorio;

@RestController
@RequestMapping ("/api/Movimiento")
public class MovimientoControlador {

    private final MovimientoRepositorio repositorio;

    public MovimientoControlador (MovimientoRepositorio repositorio){
        this.repositorio = repositorio;
    }
    
    @GetMapping
    public List<Movimiento>listar(){
        return repositorio.findAll();
    }

    @GetMapping("/{id}")
    public Movimiento obtenerPorId (@PathVariable Long id){
        return repositorio.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Movimiento con ID:" + id + "no encontrado"));
        
    }

    @PostMapping
    public Movimiento crear(@RequestBody Movimiento movimiento) {
        return repositorio.save(movimiento);
    }

    @DeleteMapping("/{id}")
    public void eliminar (@PathVariable long id){
        if (!repositorio.existsById(id)) {
            throw new ResourceNotFoundException("Movimiento con ID:" + id + "no encontrado");
        }
        repositorio.deleteById(id);
    }
}
