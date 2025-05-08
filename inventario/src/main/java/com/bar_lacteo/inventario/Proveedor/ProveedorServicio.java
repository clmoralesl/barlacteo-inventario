package com.bar_lacteo.inventario.Proveedor;

import java.util.List;

import org.springframework.stereotype.Service;



@Service
public class ProveedorServicio {

    private final ProveedorRepositorio repository;

    public ProveedorServicio(ProveedorRepositorio repository) {
        this.repository = repository;
    }

    public List<Proveedor> listar() {
        return repository.findAll();
    }

    public Proveedor guardar(Proveedor proveedor) {
        return repository.save(proveedor);
    }

    public Proveedor buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}