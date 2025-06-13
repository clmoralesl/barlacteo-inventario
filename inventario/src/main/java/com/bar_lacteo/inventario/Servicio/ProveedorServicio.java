package com.bar_lacteo.inventario.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bar_lacteo.inventario.Modelo.Proveedor;
import com.bar_lacteo.inventario.Repositorio.ProveedorRepositorio;



@Service
public class ProveedorServicio {

    private final ProveedorRepositorio repository;

    public ProveedorServicio(ProveedorRepositorio repository) {
        this.repository = repository;
    }

    public List<Proveedor> listar() {
        return repository.findAll();
    }

    /*public Proveedor guardar(Proveedor proveedor) {
        return repository.save(proveedor);
    }*/
    public Proveedor guardar(Proveedor proveedor) {
        // Limpiar espacios en los campos de tipo String
        proveedor.setNombreProveedor(proveedor.getNombreProveedor().trim());
        proveedor.setEmailProveedor(proveedor.getEmailProveedor().trim());
        proveedor.setDireccionProveedor(proveedor.getDireccionProveedor().trim());
        Optional<Proveedor> existente = repository.findByRutProveedorAndDvProveedor(
            proveedor.getRutProveedor(),
            proveedor.getDvProveedor()
        );
    
        if (existente.isPresent()) {
            throw new IllegalStateException("Ya existe un proveedor con ese RUT.");
        }
        if (repository.findByEmailProveedor(proveedor.getEmailProveedor()).isPresent()) {
            throw new IllegalStateException("Ya existe un proveedor con ese correo electrónico.");
        }
    
        return repository.save(proveedor);
    }

    public Proveedor buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}