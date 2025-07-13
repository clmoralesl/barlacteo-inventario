package com.bar_lacteo.inventario.Controlador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bar_lacteo.inventario.DTO.DetalleVentaDTO;
import com.bar_lacteo.inventario.Exception.ResourceNotFoundException;
import com.bar_lacteo.inventario.Modelo.Movimiento;
import com.bar_lacteo.inventario.Repositorio.MovimientoRepositorio;
import com.bar_lacteo.inventario.Servicio.MovimientoServicio;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/movimiento")
public class MovimientoControlador {

    private final MovimientoRepositorio repositorio;
    private final MovimientoServicio movimientoServicio;

    public MovimientoControlador(MovimientoRepositorio repositorio, MovimientoServicio movimientoServicio) {
        this.repositorio = repositorio;
        this.movimientoServicio = movimientoServicio;
    }

    @GetMapping
    public List<Movimiento> listar() {
        return repositorio.findAll();
    }

    @GetMapping("/{id}")
    public Movimiento obtenerPorId(@PathVariable Long id) {
        return repositorio.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Movimiento con ID:" + id + " no encontrado"));
    }

    // Nuevo endpoint: registra movimiento y asigna fecha automáticamente
    @PostMapping("/registrar")
    public ResponseEntity<?> registrarMovimiento(@RequestBody Movimiento movimiento) {
        try {
            Movimiento movimientoGuardado = movimientoServicio.registrarMovimiento(movimiento);
            return ResponseEntity.status(HttpStatus.CREATED).body(movimientoGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al registrar movimiento: " + e.getMessage());
        }
    }

    @PostMapping
    public Movimiento crear(@RequestBody Movimiento movimiento) {
        return repositorio.save(movimiento);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable long id) {
        if (!repositorio.existsById(id)) {
            throw new ResourceNotFoundException("Movimiento con ID:" + id + " no encontrado");
        }
        repositorio.deleteById(id);
    }

    @GetMapping("/ventas/detalle-ultimomes")
    public List<DetalleVentaDTO> detalleVentasUltimoMes() {
        LocalDateTime fechaInicio = LocalDate.now().minusMonths(1).atStartOfDay();
        LocalDateTime fechaFin = LocalDate.now().plusDays(1).atTime(LocalTime.MAX);
        return repositorio.findDetalleVentasUltimoMes(fechaInicio, fechaFin);
    }

    @GetMapping("/ventas/detalle-dia")
    public List<DetalleVentaDTO> detalleVentasDelDia() {
        LocalDateTime fechaInicio = LocalDate.now().atStartOfDay();
        LocalDateTime fechaFin = LocalDate.now().atTime(LocalTime.MAX);
        return repositorio.findDetalleVentasDelDia(fechaInicio, fechaFin);
    }

    @GetMapping("/ventas/detalle-general")
    public List<DetalleVentaDTO> detalleVentasGeneral() {
        return repositorio.findDetalleVentasGeneral();
    }

    @GetMapping("/alt")
    public RepresentationModel<?> hateoasRoot() {
        RepresentationModel<?> model = new RepresentationModel<>();
        model.add(linkTo(methodOn(MovimientoControlador.class).listar()).withRel("listar-movimientos"));
        model.add(linkTo(methodOn(MovimientoControlador.class).registrarMovimiento(null)).withRel("registrar-movimiento"));
        model.add(linkTo(methodOn(MovimientoControlador.class).detalleVentasUltimoMes()).withRel("detalle-ventas-ultimomes"));
        model.add(linkTo(methodOn(MovimientoControlador.class).detalleVentasDelDia()).withRel("detalle-ventas-dia"));
        model.add(linkTo(methodOn(MovimientoControlador.class).detalleVentasGeneral()).withRel("detalle-ventas-general"));
        // Puedes agregar más enlaces según tus endpoints
        return model;
    }
}
