package com.bar_lacteo.inventario.Proveedor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepositorio extends JpaRepository<Proveedor, Long> {
    Optional<Proveedor> findByRutProveedorAndDvProveedor(Integer rutProveedor, String dvProveedor);
    Optional<Proveedor> findByEmailProveedor(String emailProveedor);

}

