package com.bar_lacteo.inventario.Ubicacion;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bar_lacteo.inventario.Exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/ubicacion")

public class UbicacionControlador {

    private final UbicacionRepositorio repositorio;

    public UbicacionControlador(UbicacionRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @GetMapping
    public List<Ubicacion>listar(){
        return repositorio.findAll();
    }
    
    @GetMapping("/{id}")
    public Ubicacion obtenerPorId(@PathVariable Long id) {
        return repositorio.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException ("ubicacion con ID:" + id + "no encontrada"));

    }

    @PostMapping
    public Ubicacion crear(@RequestBody Ubicacion ubicacion){
        return repositorio.save(ubicacion);
    }

    @DeleteMapping
    public void eliminar(@PathVariable Long id){
        if (!repositorio.existsById(id)){
            throw new ResourceNotFoundException ("ubicacion con ID:" + id + "no encontrada");
        }
        repositorio.deleteById(id);
    }
 

}
