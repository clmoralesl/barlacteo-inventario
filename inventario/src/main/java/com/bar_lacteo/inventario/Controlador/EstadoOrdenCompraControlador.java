package com.bar_lacteo.inventario.Controlador;


import com.bar_lacteo.inventario.Exception.ResourceNotFoundException;
import com.bar_lacteo.inventario.Modelo.EstadoOrdenCompra;
import com.bar_lacteo.inventario.Repositorio.EstadoOrdenCompraRepositorio;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/estado-orden-compra")
public class EstadoOrdenCompraControlador {
    private final EstadoOrdenCompraRepositorio repositorio;

    public EstadoOrdenCompraControlador (EstadoOrdenCompraRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping
    public List <EstadoOrdenCompra> list() {
        return repositorio.findAll();
    } 

    @GetMapping("/{id}")
    public EstadoOrdenCompra obtenerPorId(@PathVariable Long id) {
        return repositorio.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Estado de orden ID:" + id + "no encontrada"));
    }

    @PostMapping
    public EstadoOrdenCompra crear(@RequestBody EstadoOrdenCompra estadoOrden) {
        return repositorio.save(estadoOrden);        
    }

    @DeleteMapping ("/{id}")
    public void eliminar(@PathVariable Long id) {
        if(!repositorio.existsById(id)) {
            throw new ResourceNotFoundException(("Estado de orden ID:" + id + "no encontrada"));
        }
        repositorio.deleteById(id);
    }
    
}
