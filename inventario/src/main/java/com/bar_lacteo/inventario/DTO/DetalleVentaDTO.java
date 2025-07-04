package com.bar_lacteo.inventario.DTO;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetalleVentaDTO {
    private String nombreProducto;
    private Long unidadesVendidas;      
    private Integer precioUnitario;
    private Long precioTotal;           
    private String nombreCategoria;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDateTime fechaMovimiento;
}