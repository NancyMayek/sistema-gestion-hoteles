package com.hotel.commons.dto;
import java.time.LocalDate;

public record ReservaResponse (
	 Long id,
	 String huesped,
	 //HabitacionInfo habitacion,
	 LocalDate fechaEntrada,
	 LocalDate fechaSalida,
	 Integer noches,
	 Double total,
	 //EstadoReserva estado,
	 LocalDate fechaCreacion
		
		){
}