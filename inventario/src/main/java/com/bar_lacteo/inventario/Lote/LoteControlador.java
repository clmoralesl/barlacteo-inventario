
package com.bar_lacteo.inventario.Lote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;

@RestController
@RequestMapping("/api/lote")

public class LoteControlador {

    @Autowired
    private LoteServicio loteServicio;


    @PostMapping("/registrar")
    public ResponseEntity<?> registrarLote(@RequestBody Lote lote){
        try{
            Lote loteGuardado = loteServicio.crearLote(lote);
            return ResponseEntity.ok(loteGuardado);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar Lote: " + e.getMessage());
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarLotes(){
        try{
            List<Lote> lotes = loteServicio.listarLotes();
            return ResponseEntity.ok(lotes);
        }catch (IllegalStateException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al listar lotes: " + e.getMessage());
        }
    }
    

}