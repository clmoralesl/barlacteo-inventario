
package com.bar_lacteo.inventario.Lote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class LoteServicio {
    @Autowired
    private LoteRepositorio loteRepositorio;


    @Transactional
    public Lote crearLote(Lote lote){
        if(loteRepositorio.existsById(lote.getIdLote())){
            throw new IllegalArgumentException("Lote ya registrado");
        }
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
