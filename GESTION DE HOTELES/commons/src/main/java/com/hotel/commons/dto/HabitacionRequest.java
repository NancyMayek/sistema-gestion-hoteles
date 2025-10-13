package com.hotel.commons.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record HabitacionRequest(
	@NotNull(message = "El número de la habitación es requerido")
	@Positive(message = "El número de la habitación debe ser positivo")
	Short numero,
	
	@NotNull(message="La capacidad de la habitacion es requerida")
	String tipo,
	
	@NotBlank(message = "La descripcion es requerida")
	@Size(min = 1, max = 50, message = "La descripción debe tener entre 1 y 50 caracteres")
	String descripcion,
	
	@Positive(message = "El precio debe ser positivo")
	Double precio,
	
	@NotNull(message="La capacidad de la habitacion es requerida")
	@Min(value = 1, message = "La capacidad de la habitacion no puede ser menor a 1")
	Short capacidad,
	
	@Positive(message="La categoria debe ser positiva")
	String idEstado
) {}
