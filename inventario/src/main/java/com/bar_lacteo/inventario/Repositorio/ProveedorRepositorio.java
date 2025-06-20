package com.bar_lacteo.inventario.Repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bar_lacteo.inventario.Modelo.Proveedor;

public interface ProveedorRepositorio extends JpaRepository<Proveedor, Long> {
    Optional<Proveedor> findByRutProveedorAndDvProveedor(Integer rutProveedor, String dvProveedor);
    Optional<Proveedor> findByEmailProveedor(String emailProveedor);
    Optional<Proveedor> findByRutProveedor(Integer rutProveedor);

}

