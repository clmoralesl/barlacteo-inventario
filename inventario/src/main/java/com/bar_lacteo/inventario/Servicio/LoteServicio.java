
package com.bar_lacteo.inventario.Servicio;

import java.util.List;

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







}
