package com.bar_lacteo.inventario.Servicio;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bar_lacteo.inventario.Modelo.Categoria;
import com.bar_lacteo.inventario.Repositorio.CategoriaRepositorio;
import com.bar_lacteo.inventario.Repositorio.ProductoRepositorio;
import com.bar_lacteo.inventario.Servicio.CategoriaServicio;

@SpringBootTest
public class CategoriaServicioTest {

    @MockBean
    private CategoriaRepositorio categoriaRepositorio;

    @MockBean
    private ProductoRepositorio productoRepositorio;

    @Autowired
    private CategoriaServicio categoriaServicio;

    @Test
    public void testRegistrarCategoriaOk() {
        String nombre = "Lácteos";

        when(categoriaRepositorio.findByNombreCategoria(nombre)).thenReturn(Optional.empty());
        when(categoriaRepositorio.save(any(Categoria.class)))
            .thenAnswer(invocation -> invocation.getArgument(0));

        Categoria nueva = categoriaServicio.registrar(nombre);

        assertEquals("Lácteos", nueva.getNombreCategoria());
    }

    @Test
    public void testRegistrarCategoriaYaExiste() {
        String nombre = "Bebidas";

        when(categoriaRepositorio.findByNombreCategoria(nombre))
            .thenReturn(Optional.of(new Categoria(nombre)));

        assertThrows(IllegalStateException.class, () -> {
            categoriaServicio.registrar(nombre);
        });
    }

    @Test
    public void testEliminarCategoriaOk() {
        Integer id = 1;

        when(categoriaRepositorio.existsById(id)).thenReturn(true);
        when(productoRepositorio.existsByCategoriaIdCategoria(id)).thenReturn(false);
        doNothing().when(categoriaRepositorio).deleteById(id);

        assertDoesNotThrow(() -> categoriaServicio.eliminarCategoria(id));
    }

    @Test
    public void testEliminarCategoriaNoExiste() {
        Integer id = 999;

        when(categoriaRepositorio.existsById(id)).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> categoriaServicio.eliminarCategoria(id));
    }

    @Test
    public void testEliminarCategoriaConProductos() {
        Integer id = 2;

        when(categoriaRepositorio.existsById(id)).thenReturn(true);
        when(productoRepositorio.existsByCategoriaIdCategoria(id)).thenReturn(true);

        assertThrows(IllegalStateException.class, () -> categoriaServicio.eliminarCategoria(id));
    }

    @Test
    public void testActualizarNombreOk() {
        Integer id = 1;
        Categoria existente = new Categoria("Antiguo");
        String nuevoNombre = "Confitería";

        when(categoriaRepositorio.findById(id)).thenReturn(Optional.of(existente));
        when(categoriaRepositorio.findByNombreCategoria(nuevoNombre)).thenReturn(Optional.empty());
        when(categoriaRepositorio.save(any(Categoria.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Categoria actualizada = categoriaServicio.actualizarNombre(id, nuevoNombre);

        assertEquals("Confitería", actualizada.getNombreCategoria());
    }

    @Test
    public void testActualizarNombreCategoriaNoExiste() {
        Integer id = 123;

        when(categoriaRepositorio.findById(id)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> categoriaServicio.actualizarNombre(id, "Nuevo"));
    }

    @Test
    public void testActualizarNombreYaExiste() {
        Integer id = 1;
        Categoria existente = new Categoria("Antiguo");

        when(categoriaRepositorio.findById(id)).thenReturn(Optional.of(existente));
        when(categoriaRepositorio.findByNombreCategoria("Duplicado")).thenReturn(Optional.of(new Categoria("Duplicado")));

        assertThrows(IllegalStateException.class, () -> categoriaServicio.actualizarNombre(id, "Duplicado"));
    }
}
