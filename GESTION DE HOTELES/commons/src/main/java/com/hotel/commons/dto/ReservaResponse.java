package com.hotel.commons.dto;
<<<<<<< HEAD
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
=======

import java.time.LocalDate;

public record ReservaResponse(
    Long id,
    String huesped,
    Long idHabitacion,
    LocalDate fechaEntrada,
    LocalDate fechaSalida,
    Integer noches,
    Double total,
    Long idEstado
) {} 
>>>>>>> ec5e25c65c39623364a59f5b23f958f0171a875d
