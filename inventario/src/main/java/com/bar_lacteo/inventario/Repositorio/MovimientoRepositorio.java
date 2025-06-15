package com.bar_lacteo.inventario.Repositorio;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bar_lacteo.inventario.DTO.DetalleVentaDTO;
import com.bar_lacteo.inventario.Modelo.Movimiento;

public interface MovimientoRepositorio extends JpaRepository<Movimiento, Long> {
    @Query("SELECT m FROM Movimiento m WHERE m.tipoMovimiento.idTipoMovimiento = :tipoMovimientoId AND MONTH(m.fechaMovimiento) = MONTH(CURRENT_DATE) AND YEAR(m.fechaMovimiento) = YEAR(CURRENT_DATE)")
    List<Movimiento> findByTipoMovimientoAndMesActual(int tipoMovimientoId);

    @Query("SELECT new com.bar_lacteo.inventario.DTO.DetalleVentaDTO(" +
           "m.producto.nombreProducto, " +
           "SUM(m.unidades), " +
           "m.producto.precioUnitario, " +
           "SUM(m.unidades) * m.producto.precioUnitario, " +
           "m.producto.categoria.nombreCategoria) " +
           "FROM Movimiento m " +
           "WHERE m.tipoMovimiento.idTipoMovimiento = 2 " +
           "AND m.fechaMovimiento >= :fechaInicio " +
           "AND m.fechaMovimiento <= :fechaFin " +
           "GROUP BY m.producto.nombreProducto, m.producto.precioUnitario, m.producto.categoria.nombreCategoria")
    List<DetalleVentaDTO> findDetalleVentasUltimoMes(
        @Param("fechaInicio") LocalDateTime fechaInicio,
        @Param("fechaFin") LocalDateTime fechaFin
    );
}
