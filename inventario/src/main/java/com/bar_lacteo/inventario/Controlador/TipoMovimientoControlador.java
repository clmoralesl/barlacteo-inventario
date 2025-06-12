package com.bar_lacteo.inventario.Controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bar_lacteo.inventario.Modelo.TipoMovimiento;
import com.bar_lacteo.inventario.Repositorio.TipoMovimientoRepositorio;

@RestController
@RequestMapping("/api/tipo-movimiento")
public class TipoMovimientoControlador {

    private final TipoMovimientoRepositorio repositorio;

    public TipoMovimientoControlador (TipoMovimientoRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @GetMapping
    public List<TipoMovimiento>listar(){
        return repositorio.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<TipoMovimiento> obtenerPorId(@PathVariable Long id){
        return repositorio.findById(id);
    }
    @PostMapping
    public TipoMovimiento crear(@RequestBody TipoMovimiento tipoMovimiento){
        return repositorio.save(tipoMovimiento);
    }
    @DeleteMapping
    public void eliminar(@PathVariable Long  id){
        repositorio.deleteById(id);
    }
}
