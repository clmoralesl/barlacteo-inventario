package com.bar_lacteo.inventario.Servicio;

import com.bar_lacteo.inventario.Modelo.Producto;
import com.bar_lacteo.inventario.Repositorio.ProductoRepositorio;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductoServicioTest {

    @MockBean
    private ProductoRepositorio productoRepositorio;

    @Autowired
    private ProductoServicio productoServicio;

    @Test
    public void testCrearProducto() {
        Producto producto = new Producto();
        producto.setCodigoBarra(123);
        producto.setNombreProducto("Leche");

        when(productoRepositorio.existsByCodigoBarra(123)).thenReturn(false);
        when(productoRepositorio.save(producto)).thenReturn(producto);

        Producto resultado = productoServicio.crearProducto(producto);

        assertEquals("Leche", resultado.getNombreProducto());
        assertEquals(123, resultado.getCodigoBarra());
    }

    @Test
    public void testEliminarProductoExistente() {
        Integer codigoBarra = 123;

        when(productoRepositorio.existsByCodigoBarra(codigoBarra)).thenReturn(true);
        doNothing().when(productoRepositorio).deleteByCodigoBarra(codigoBarra);

        assertDoesNotThrow(() -> productoServicio.eliminarProducto(codigoBarra));
    }

    @Test
    public void testEliminarProductoNoExistente() {
        Integer codigoBarra = 999;

        when(productoRepositorio.existsByCodigoBarra(codigoBarra)).thenReturn(false);

        Exception exception = assertThrows(EntityNotFoundException.class, () -> {
            productoServicio.eliminarProducto(codigoBarra);
        });

        assertTrue(exception.getMessage().contains("no existe"));
    }
    
}