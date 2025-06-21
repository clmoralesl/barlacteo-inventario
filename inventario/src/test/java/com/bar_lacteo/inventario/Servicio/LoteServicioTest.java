package com.bar_lacteo.inventario.Servicio;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bar_lacteo.inventario.Modelo.Lote;
import com.bar_lacteo.inventario.Repositorio.LoteRepositorio;

@SpringBootTest
public class LoteServicioTest {

    @MockBean
    private LoteRepositorio loteRepositorio;

    @Autowired
    private LoteServicio loteServicio;

    @Test
public void testCrearLote() {
    Lote lote = new Lote();
    lote.setNumeroLote(1); // <- ahora es Integer

    when(loteRepositorio.save(lote)).thenReturn(lote);

    Lote resultado = loteServicio.crearLote(lote);

    assertNotNull(resultado);
    assertEquals(1, resultado.getNumeroLote());
}
   @Test
public void testListarLotesConLotes() {
    Lote lote1 = new Lote();
    lote1.setNumeroLote(1);

    Lote lote2 = new Lote();
    lote2.setNumeroLote(2);

    when(loteRepositorio.findAll()).thenReturn(Arrays.asList(lote1, lote2));

    List<Lote> lotes = loteServicio.listarLotes();

    assertEquals(2, lotes.size());
    assertEquals(1, lotes.get(0).getNumeroLote());
}
    @Test
    public void testListarLotesVacio() {
        when(loteRepositorio.findAll()).thenReturn(Collections.emptyList());

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            loteServicio.listarLotes();
        });

        assertEquals("No hay lotes registrados.", exception.getMessage());
    }
}
