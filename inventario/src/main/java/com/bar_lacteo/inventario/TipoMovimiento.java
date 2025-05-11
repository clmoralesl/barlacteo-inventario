package com.bar_lacteo.inventario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipo_movimiento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TipoMovimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id_tipo_movimiento")
    private Long idTipoMovimiento;

    @NotBlank(message = "Debe ingresar descripción")
    @Size(max = 10, message = "Maximo 10 caracteres")
    @Column(name = "descripcion_tipo_movimiento")
    private String descripcionTipoMovimiento;



    
}
