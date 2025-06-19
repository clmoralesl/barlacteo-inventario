package com.bar_lacteo.inventario.com.bar_lacteo.inventario.OrdenCompra;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bar_lacteo.inventario.Modelo.OrdenCompra;
import com.bar_lacteo.inventario.Repositorio.OrdenCompraRepositorio;
import com.bar_lacteo.inventario.Servicio.OrdenCompraServicio;

@SpringBootTest
public class OrdenCompraServicioTest {

    @MockBean
    private OrdenCompraRepositorio ordenCompraRepositorio;

    @Autowired
    private OrdenCompraServicio ordenCompraServicio;

    @Test
    public void testGuardarOrdenCompra() {
        OrdenCompra orden = new OrdenCompra();
        orden.setId(1L);

        when(ordenCompraRepositorio.save(orden)).thenReturn(orden);

        OrdenCompra resultado = ordenCompraServicio.guardar(orden);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
    }

    @Test
    public void testListarOrdenes() {
        OrdenCompra orden1 = new OrdenCompra();
        orden1.setId(1L);

        OrdenCompra orden2 = new OrdenCompra();
        orden2.setId(2L);

        when(ordenCompraRepositorio.findAll()).thenReturn(Arrays.asList(orden1, orden2));

        List<OrdenCompra> ordenes = ordenCompraServicio.listar();

        assertEquals(2, ordenes.size());
        assertEquals(1L, ordenes.get(0).getId());
    }

    @Test
    public void testBuscarPorIdExistente() {
        OrdenCompra orden = new OrdenCompra();
        orden.setId(10L);

        when(ordenCompraRepositorio.findById(10L)).thenReturn(Optional.of(orden));

        OrdenCompra resultado = ordenCompraServicio.buscarPorId(10L);

        assertNotNull(resultado);
        assertEquals(10L, resultado.getId());
    }

    @Test
    public void testBuscarPorIdNoExistente() {
        when(ordenCompraRepositorio.findById(999L)).thenReturn(Optional.empty());

        OrdenCompra resultado = ordenCompraServicio.buscarPorId(999L);

        assertNull(resultado);
    }

    @Test
    public void testEliminarOrden() {
        Long id = 5L;
        doNothing().when(ordenCompraRepositorio).deleteById(id);

        assertDoesNotThrow(() -> ordenCompraServicio.eliminar(id));
        verify(ordenCompraRepositorio, times(1)).deleteById(id);
    }
}
