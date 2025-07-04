package com.bar_lacteo.inventario.Modelo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lote")

public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lote")
    private Integer idLote;

    @ManyToOne
    @JoinColumn(name = "cod_barra", nullable = false)
    private Producto producto; 

    @Column(name = "numero_lote")
    private Integer numeroLote;

    @Column(name = "stock_lote")
    private Integer stockLote;

    @Column(name = "fecha_vencimiento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fechaVencimiento;

    @ManyToOne
    @JoinColumn(name = "id_orden_compra")
    private OrdenCompra ordenCompra;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "id_ubicacion")
    private Ubicacion ubicacion;

}