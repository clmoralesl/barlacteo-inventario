package com.bar_lacteo.inventario.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.bar_lacteo.inventario.Modelo.Lote;
import com.bar_lacteo.inventario.Modelo.Movimiento;
import com.bar_lacteo.inventario.Modelo.TipoMovimiento;
import com.bar_lacteo.inventario.Servicio.LoteServicio;
import com.bar_lacteo.inventario.Servicio.MovimientoServicio;
import com.bar_lacteo.inventario.Repositorio.TipoMovimientoRepositorio;

import java.util.*;

@RestController
@RequestMapping("/api/lote")
public class LoteControlador {

    @Autowired
    private LoteServicio loteServicio;

    @Autowired
    private MovimientoServicio movimientoServicio;

    @Autowired
    private TipoMovimientoRepositorio tipoMovimientoRepositorio;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarLote(@RequestBody Lote lote, @RequestHeader("Authorization") String authHeader) {
        try {
            Lote loteGuardado = loteServicio.crearLote(lote);

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", authHeader);
            HttpEntity<Void> entity = new HttpEntity<>(headers);

            ResponseEntity<Map> response = restTemplate.exchange(
                "http://localhost:8081/api/auth/me",
                HttpMethod.GET,
                entity,
                Map.class
            );

            Long idUsuario = 1L; // Valor por defecto
            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null && response.getBody().get("id") != null) {
                idUsuario = Long.valueOf(response.getBody().get("id").toString());
            }

            TipoMovimiento tipoMovimiento = tipoMovimientoRepositorio.findById(1L)
                .orElseThrow(() -> new RuntimeException("TipoMovimiento 'Entrada por Compra' no encontrado"));

            Movimiento movimiento = new Movimiento();
            movimiento.setLote(loteGuardado);
            movimiento.setProducto(loteGuardado.getProducto());
            movimiento.setUnidades(loteGuardado.getStockLote() != null ? loteGuardado.getStockLote().longValue() : 0L);
            movimiento.setTipoMovimiento(tipoMovimiento);
            movimiento.setFechaMovimiento(java.time.LocalDateTime.now());
            movimiento.setIdUsuario(idUsuario);

            movimientoServicio.registrarMovimiento(movimiento);

            return ResponseEntity.ok(loteGuardado);
        } catch (Exception e) {
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
    
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerLotePorId(@PathVariable Integer id) {
        try {
            Lote lote = loteServicio.obtenerLotePorId(id);
            return ResponseEntity.ok(lote);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lote no encontrado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener lote: " + e.getMessage());
        }
    }

}