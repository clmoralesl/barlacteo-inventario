package com.bar_lacteo.inventario.DetalleOrdenCompra;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bar_lacteo.inventario.Exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/detalle-orden-compra")

public class DetalleOrdenCompraControlador {

    private final DetalleOrdenCompraRepositorio repositorio;

    public DetalleOrdenCompraControlador( DetalleOrdenCompraRepositorio respositorio) {
        this.repositorio = respositorio;
    }
    
    @GetMapping
    public List<DetalleOrdenCompra> list() {
        return repositorio.findAll();
    }

    @GetMapping("/{id}")
    public DetalleOrdenCompra obtenerPorId (@PathVariable Long id) {
        return repositorio.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Detalle ID:" +id+"no encontrado"));
    }

    @PostMapping
    public DetalleOrdenCompra crear (@RequestBody DetalleOrdenCompra detalle) {
        return repositorio.save(detalle);
    }
    @DeleteMapping
    public void  eliminar(@PathVariable Long id) {
        if (!repositorio.existsById(id)) {
            throw new ResourceNotFoundException("Detalle ID:" +id+"no encontrado");
        }
        repositorio.deleteById(id);
    }
}
