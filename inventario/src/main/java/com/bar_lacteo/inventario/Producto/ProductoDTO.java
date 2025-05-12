package com.bar_lacteo.inventario.Producto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductoDTO {
    private Integer codBarra;
    private String nombreProducto;
    private Integer precio;
    private Integer stockActual;
    private Integer stockMin;
    private String categoria;

}
