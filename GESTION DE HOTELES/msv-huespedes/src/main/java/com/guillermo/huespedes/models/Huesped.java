package com.guillermo.huespedes.models;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "huespedes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Huesped {
    
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_HUESPED")
	@SequenceGenerator(name="SEQ_HUESPED",sequenceName="SEQ_HUESPED",allocationSize = 1)
	@Column(name= "ID_HUESPED")
	private Long id;
    
    @Column(name = "NOMBRE", nullable = false)
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 10, message = "El nombre debe tener al menos 10 caracteres")
    private String nombre;
    
    @Column(name = "APELLIDO", nullable = false)
    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 10, message = "El apellido debe tener al menos 10 caracteres")
    private String apellido;
    
    @Column(name = "EMAIL", nullable = false, unique = true, length = 150)
    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El email debe ser válido")
    private String email;
    
    @Column(name = "TELEFONO", nullable = false, unique = true, length = 10)
    @NotBlank(message = "El teléfono no puede estar vacío")
    @Pattern(regexp = "^\\d{10}$", message = "El teléfono debe tener exactamente 10 dígitos")
    private String telefono;
    
    @Column(name = "DOCUMENTO", nullable = false, length = 20)
    @NotNull(message = "El documento no puede estar vacío")
    private Long idDocumento;
    
    @Column(name = "NACIONALIDAD", nullable = false, length = 50)
    @NotBlank(message = "La nacionalidad no puede estar vacía")
    private String nacionalidad;
    
}