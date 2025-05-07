package com.bar_lacteo.inventario.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/producto")
public class ProductoControlador {
    private final ProductoRepositorio productoRepositorio;

    @Autowired
    private ProductoServicio productoServicio;

    ProductoControlador(ProductoRepositorio productoRepositorio){
        this.productoRepositorio = productoRepositorio;
    }

    @PostMapping("/registrar")
    public ResponseEntity<Producto> registrarProducto(@RequestBody Producto producto){
        Producto nuevoProducto = new Producto();
        nuevoProducto.setIdProducto(producto.get);
        nuevoProducto.setNombreProducto(producto.getNombreProducto().trim());
        nuevoProducto.setDescripcion(producto.getDescripcion() !=null ? producto.getDescripcion().trim():null );
        nuevoProducto.setPrecioUnitario(producto.getPrecioUnitario());
        nuevoProducto.setCategoria(producto.getCategoria());

        return ResponseEntity.ok(productoServicio.creaProducto(nuevoProducto));
    }    


}
