package com.bar_lacteo.inventario.Producto;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductoRepositorio extends JpaRepository<Producto,Integer> {

    boolean existsByCodigoBarra(Integer codigoBarra);
    Optional<Producto>findByCodigoBarra(Integer codigoBarra);

}
