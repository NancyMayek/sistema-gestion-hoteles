package com.hotel.commons.dto;

public record HabitacionResponse(
	Long id,
	Short numero,
	String tipo,	
	String descripcion,		
	Double precio,		
	Short capacidad,	
	String idEstado
	)
{}
