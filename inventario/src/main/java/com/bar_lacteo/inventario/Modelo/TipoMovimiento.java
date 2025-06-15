package com.bar_lacteo.inventario.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_Tipo_Movimiento")
   private Long idTipoMovimiento;
   
   @Column(name = "descripcion_Tipo_Movimiento", nullable = false)
   private String descripcionTipoMovimiento;

   @Column(name = "es_entrada")
   private Boolean entrada;

}
