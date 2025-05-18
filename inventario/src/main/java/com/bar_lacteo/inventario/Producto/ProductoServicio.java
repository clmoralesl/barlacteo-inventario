package com.bar_lacteo.inventario.Producto;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
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

    public void eliminarProducto(Integer codigoBarra) {
        if (!productoRepositorio.existsByCodigoBarra(codigoBarra)) {
            throw new EntityNotFoundException("El código de barra " + codigoBarra + " no existe.");
        }
      productoRepositorio.deleteById(codigoBarra);
    }

    public List<ProductoDTO> listarProductos(){
        List<Object[]> datos = productoRepositorio.listarProductos();
        List<ProductoDTO> productosdto  = new ArrayList<>();
        for(Object[] fila : datos){
            Integer stockActual = ((BigDecimal) fila[3]).intValue();
            ProductoDTO producto = new ProductoDTO(
                (Integer) fila[0], 
                (String) fila[1],
                (Integer) fila[2],
                stockActual,
                (Integer) fila[4],
                (String) fila[5]);
            productosdto.add(producto);}
            return productosdto;
    }

        public List<ProductoDTO> productoBajoStock(){
        List<Object[]> datos = productoRepositorio.productosStockBajo();
        List<ProductoDTO> productosdto  = new ArrayList<>();
        for(Object[] fila : datos){
            Integer stockActual = ((BigDecimal) fila[3]).intValue();
            ProductoDTO producto = new ProductoDTO(
                (Integer) fila[0], 
                (String) fila[1],
                (Integer) fila[2],
                stockActual,
                (Integer) fila[4],
                (String) fila[5]);
            productosdto.add(producto);}
            return productosdto;
    }

    @Transactional
    public Producto actualizarProducto(Integer codigoBarra, Producto productoActualizado) {

        Producto productoExistente = productoRepositorio.findByCodigoBarra(codigoBarra)
                .orElseThrow(() -> new EntityNotFoundException("Producto con código de barra " + codigoBarra + " no encontrado"));

        productoExistente.setNombreProducto(productoActualizado.getNombreProducto());
        productoExistente.setDescripcion(productoActualizado.getDescripcion());
        productoExistente.setPrecioUnitario(productoActualizado.getPrecioUnitario());
        productoExistente.setStockMinimo(productoActualizado.getStockMinimo());
        productoExistente.setCategoria(productoActualizado.getCategoria());

        return productoRepositorio.save(productoExistente);
    }

}
