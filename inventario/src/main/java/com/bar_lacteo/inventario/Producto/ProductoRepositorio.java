package com.bar_lacteo.inventario.Producto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto,Integer> {

    boolean existsByCodigoBarra(Integer codigoBarra);

}
