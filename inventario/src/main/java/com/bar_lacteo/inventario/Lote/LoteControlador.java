/*
package com.bar_lacteo.inventario.Lote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordenCompra")

public class LoteControlador {
    private final LoteRepositorio loteRepositorio;

    @Autowired
    private LoteServicio loteServicio;

    LoteControlador(LoteRepositorio loteRepositorio){
        this.loteRepositorio = loteRepositorio;
    }

    @PostMapping("/registrar")
    public ResponseEntity<Lote> registrarLote(@RequestBody Lote lote){
        Lote nuevoLote = new Lote();
        nuevoLote.setIdLote(lote.getIdLote());
        nuevoLote.setNumeroLote(lote.getNumeroLote());
        nuevoLote.setOrdenCompra(lote.getOrdenCompra());
        nuevoLote.setProducto(lote.getProducto());
        nuevoLote.setProveedor(lote.getProveedor());
        nuevoLote.setStockLote(lote.getStockLote());

        return ResponseEntity.ok(loteServicio.crearLote(nuevoLote));
    }



} */
