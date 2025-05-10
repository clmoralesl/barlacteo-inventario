package com.bar_lacteo.inventario.Proveedor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Clave primaria técnica, autogenerada

    @Column(name = "rut_proveedor", nullable = false)
    private Integer rutProveedor; // solo el número del RUT (ej: 12345678)

    @Column(name = "dv_proveedor", nullable = false, length = 1)
    private String dvProveedor;   // dígito verificador (ej: "K" o "9")

    @NotBlank(message = "El nombre del proveedor es obligatorio")
    @Column(name = "nombre_proveedor")
    private String nombreProveedor;

    @Pattern(regexp = "^[0-9]{9}$", message = "El teléfono debe tener 9 dígitos")
    @Column(name = "telefono_proveedor")
    private String telefonoProveedor;


    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Formato de email no válido")
    @Column(name = "email_proveedor")
    private String emailProveedor;

    @Column(name = "direccion_proveedor")
    private String direccionProveedor;
