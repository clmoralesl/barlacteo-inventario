package com.bar_lacteo.inventario.Servicio;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bar_lacteo.inventario.Modelo.Lote;
import com.bar_lacteo.inventario.Repositorio.LoteRepositorio;

import jakarta.transaction.Transactional;

@Service
public class LoteServicio {
    @Autowired
    private LoteRepositorio loteRepositorio;

    @Transactional
    public Lote crearLote(Lote lote){
        return loteRepositorio.save(lote);
    }

    public List<Lote> listarLotes(){
        List<Lote> lotes = loteRepositorio.findAll();
        if(lotes.isEmpty()){
            throw new IllegalStateException("No hay lotes registrados.");
        }
        return lotes;
    }

    public Lote obtenerLotePorId(Integer id) {
        return loteRepositorio.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public Lote actualizarLote(Integer id, Lote loteActualizado) {
        Lote lote = loteRepositorio.findById(id)
                .orElseThrow(NoSuchElementException::new);
        lote.setProducto(loteActualizado.getProducto());
        lote.setNumeroLote(loteActualizado.getNumeroLote());
        lote.setStockLote(loteActualizado.getStockLote());
        lote.setFechaVencimiento(loteActualizado.getFechaVencimiento());
        lote.setOrdenCompra(loteActualizado.getOrdenCompra());
        lote.setProveedor(loteActualizado.getProveedor());
        return loteRepositorio.save(lote);
    }

    @Transactional
    public void eliminarLote(Integer id) {
        Lote lote = loteRepositorio.findById(id)
                .orElseThrow(NoSuchElementException::new);
        loteRepositorio.delete(lote);
    }

}
