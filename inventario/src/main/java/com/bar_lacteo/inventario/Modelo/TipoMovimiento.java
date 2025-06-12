package com.bar_lacteo.inventario.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "tipo_movimiento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class TipoMovimiento {

   @Id
   @Column(name = "id_Tipo_Movimiento")
   private Long idTipoMovimiento;
   
   @Column(name = "descripcion_Tipo_Movimiento", length = 10, nullable = false)
   private String descripcionTipoMovimiento;

}
