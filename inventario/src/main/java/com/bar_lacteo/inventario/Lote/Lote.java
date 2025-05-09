package com.bar_lacteo.inventario.Lote;

import java.sql.Date;

import com.bar_lacteo.inventario.OrdenCompra.OrdenCompra;
import com.bar_lacteo.inventario.Producto.Producto;
import com.bar_lacteo.inventario.Proveedor.Proveedor;

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
@Table(name = "Lote")

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
    private Date fechaVencimiento;

    @ManyToOne
    @JoinColumn(name = "id_orden_compra")
    private OrdenCompra ordenCompra;

    @ManyToOne
    @JoinColumn(name = "rut_proveedor")
    private Proveedor proveedor;

}