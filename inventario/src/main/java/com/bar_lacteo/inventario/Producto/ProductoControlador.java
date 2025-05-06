package com.bar_lacteo.inventario.Producto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/producto")
public class ProductoControlador {
    private final ProductoRepositorio productoRepositorio;

    ProductoControlador(ProductoRepositorio productoRepositorio){
        this.productoRepositorio = productoRepositorio;
    }

    
    


}
