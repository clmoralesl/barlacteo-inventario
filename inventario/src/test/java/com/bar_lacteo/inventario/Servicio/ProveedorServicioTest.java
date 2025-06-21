package com.bar_lacteo.inventario.Servicio;

import com.bar_lacteo.inventario.Modelo.Proveedor;
import com.bar_lacteo.inventario.Repositorio.ProveedorRepositorio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProveedorServicioTest {

    @MockBean
    private ProveedorRepositorio proveedorRepositorio;

    @Autowired
    private ProveedorServicio proveedorServicio;

    @Test
    public void testGuardarProveedorNuevo() {
        Proveedor proveedor = new Proveedor();
        proveedor.setRutProveedor(12345678);
        proveedor.setDvProveedor("K");
        proveedor.setNombreProveedor("Proveedor Uno");
        proveedor.setEmailProveedor("uno@mail.com");
        proveedor.setDireccionProveedor("Calle Falsa 123");

        when(proveedorRepositorio.findByRutProveedorAndDvProveedor(12345678, "K")).thenReturn(Optional.empty());
        when(proveedorRepositorio.findByEmailProveedor("uno@mail.com")).thenReturn(Optional.empty());
        when(proveedorRepositorio.save(any(Proveedor.class))).thenReturn(proveedor);

        Proveedor resultado = proveedorServicio.guardar(proveedor);

        assertNotNull(resultado);
        assertEquals("Proveedor Uno", resultado.getNombreProveedor());
    }

    @Test
    public void testGuardarProveedorExistentePorRut() {
        Proveedor proveedor = new Proveedor();
        proveedor.setRutProveedor(12345678);
        proveedor.setDvProveedor("K");
        proveedor.setNombreProveedor("Proveedor Duplicado");
        proveedor.setEmailProveedor("duplicado@mail.com");
        proveedor.setDireccionProveedor("Dirección ejemplo"); // <- Agregado

        when(proveedorRepositorio.findByRutProveedorAndDvProveedor(12345678, "K"))
                .thenReturn(Optional.of(new Proveedor()));

        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> {
            proveedorServicio.guardar(proveedor);
        });

        assertEquals("Ya existe un proveedor con ese RUT.", ex.getMessage());
    }


    @Test
    public void testGuardarProveedorExistentePorEmail() {
        Proveedor proveedor = new Proveedor();
        proveedor.setRutProveedor(12345678);
        proveedor.setDvProveedor("1");
        proveedor.setNombreProveedor("Proveedor Correo Duplicado");
        proveedor.setEmailProveedor("repetido@mail.com");
        proveedor.setDireccionProveedor("Dirección ejemplo"); // <- Agregado

        when(proveedorRepositorio.findByRutProveedorAndDvProveedor(12345678, "1")).thenReturn(Optional.empty());
        when(proveedorRepositorio.findByEmailProveedor("repetido@mail.com"))
                .thenReturn(Optional.of(new Proveedor()));

        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> {
            proveedorServicio.guardar(proveedor);
        });

        assertEquals("Ya existe un proveedor con ese correo electrónico.", ex.getMessage());
    }


    @Test
    public void testBuscarPorIdExistente() {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(1L);
        proveedor.setNombreProveedor("Proveedor X");

        when(proveedorRepositorio.findById(1L)).thenReturn(Optional.of(proveedor));

        Proveedor resultado = proveedorServicio.buscarPorId(1L);

        assertNotNull(resultado);
        assertEquals("Proveedor X", resultado.getNombreProveedor());
    }

    @Test
    public void testBuscarPorRutExistente() {
        Proveedor proveedor = new Proveedor();
        proveedor.setRutProveedor(22222222);

        when(proveedorRepositorio.findByRutProveedor(22222222)).thenReturn(Optional.of(proveedor));

        Proveedor resultado = proveedorServicio.buscarPorRut(22222222);

        assertNotNull(resultado);
        assertEquals(22222222, resultado.getRutProveedor());
    }

    @Test
    public void testBuscarPorRutInexistente() {
        when(proveedorRepositorio.findByRutProveedor(99999999)).thenReturn(Optional.empty());

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            proveedorServicio.buscarPorRut(99999999);
        });

        assertTrue(ex.getMessage().contains("Proveedor no encontrado"));
    }

    @Test
    public void testEliminarProveedor() {
        doNothing().when(proveedorRepositorio).deleteById(1L);

        assertDoesNotThrow(() -> proveedorServicio.eliminar(1L));
    }

    @Test
    public void testActualizarProveedor() {
        Proveedor original = new Proveedor();
        original.setId(1L);
        original.setNombreProveedor("Original");

        Proveedor actualizado = new Proveedor();
        actualizado.setNombreProveedor("Actualizado");
        actualizado.setRutProveedor(12345678);
        actualizado.setDvProveedor("9");
        actualizado.setEmailProveedor("nuevo@mail.com");
        actualizado.setTelefonoProveedor("123456789");
        actualizado.setDireccionProveedor("Nueva dirección");

        when(proveedorRepositorio.findById(1L)).thenReturn(Optional.of(original));
        when(proveedorRepositorio.save(any(Proveedor.class))).thenReturn(actualizado);

        Proveedor resultado = proveedorServicio.actualizar(1L, actualizado);

        assertEquals("Actualizado", resultado.getNombreProveedor());
        assertEquals("nuevo@mail.com", resultado.getEmailProveedor());
    }

}
