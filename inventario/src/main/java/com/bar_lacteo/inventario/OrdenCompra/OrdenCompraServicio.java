package com.bar_lacteo.inventario.OrdenCompra;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OrdenCompraServicio {

    private final OrdenCompraRepositorio repository;

    public OrdenCompraServicio(OrdenCompraRepositorio repository) {
        this.repository = repository;
    }

    public List<OrdenCompra> listar() {
        return repository.findAll();
    }

    public OrdenCompra guardar(OrdenCompra orden) {
        return repository.save(orden);
    }

    public OrdenCompra buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}