package com.hotel.commons.dto;

public record HabitacionResponse(
	Long id,
	Short numero,
	Long idTipo,	
	String descripcion,		
	Double precio,		
	Short capacidad,	
	Long idEstado
	)
{}
