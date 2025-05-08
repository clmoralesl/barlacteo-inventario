package com.bar_lacteo.inventario.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    public Producto crearProducto(Producto producto){
        return productoRepositorio.save(producto);
    }
    //test
}
