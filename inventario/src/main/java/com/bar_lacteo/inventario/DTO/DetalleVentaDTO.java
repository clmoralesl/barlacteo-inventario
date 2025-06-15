package com.bar_lacteo.inventario.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetalleVentaDTO {
    private String nombreProducto;
    private Long unidadesVendidas;      // Cambia a Long
    private Integer precioUnitario;
    private Long precioTotal;           // Cambia a Long
    private String nombreCategoria;
}