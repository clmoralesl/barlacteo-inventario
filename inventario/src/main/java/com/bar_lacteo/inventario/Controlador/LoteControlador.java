package com.bar_lacteo.inventario.Controlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bar_lacteo.inventario.Modelo.Lote;
import com.bar_lacteo.inventario.Servicio.LoteServicio;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.*;
import com.bar_lacteo.inventario.Assembler.LoteModeloAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Tag(name = "Lote", description = "Gestión de lotes de productos en el inventario")
@RestController
@RequestMapping("/api/lote")

public class LoteControlador {

    @Autowired
    private LoteServicio loteServicio;


    @Autowired
    private LoteModeloAssembler loteAssembler;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarLote(@RequestBody Lote lote){
        try{
            Lote loteGuardado = loteServicio.crearLote(lote);
            EntityModel<Lote> loteModel = loteAssembler.toModel(loteGuardado);
            return ResponseEntity.ok(loteModel);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar Lote: " + e.getMessage());
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarLotes(){
        try{
            List<EntityModel<Lote>> lotes = loteServicio.listarLotes()
                .stream()
                .map(loteAssembler::toModel)
                .toList();
            return ResponseEntity.ok(CollectionModel.of(lotes, linkTo(methodOn(LoteControlador.class).listarLotes()).withSelfRel()));
        }catch (IllegalStateException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al listar lotes: " + e.getMessage());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerLotePorId(@PathVariable Integer id) {
        try {
            Lote lote = loteServicio.obtenerLotePorId(id);
            EntityModel<Lote> loteModel = loteAssembler.toModel(lote);
            return ResponseEntity.ok(loteModel);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lote no encontrado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener lote: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarLote(@PathVariable Integer id, @RequestBody Lote loteActualizado) {
        try {
            Lote lote = loteServicio.actualizarLote(id, loteActualizado);
            EntityModel<Lote> loteModel = loteAssembler.toModel(lote);
            return ResponseEntity.ok(loteModel);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lote no encontrado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar lote: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarLote(@PathVariable Integer id) {
        try {
            loteServicio.eliminarLote(id);
            return ResponseEntity.ok(
                CollectionModel.of(List.of(), linkTo(methodOn(LoteControlador.class).listarLotes()).withRel("lotes"))
            );
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lote no encontrado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar lote: " + e.getMessage());
        }
    }

}