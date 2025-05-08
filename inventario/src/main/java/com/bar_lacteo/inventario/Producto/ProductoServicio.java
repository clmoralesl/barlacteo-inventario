package com.bar_lacteo.inventario.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Transactional
    public Producto crearProducto(Producto producto){
        if (productoRepositorio.existsByCodigoBarra(producto.getCodigoBarra())) {
            throw new IllegalArgumentException("Código de barras ya registrado");
        }
        return productoRepositorio.save(producto);
    }
    //test
}
