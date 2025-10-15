package com.hotel.commons.dto;

<<<<<<< HEAD
import jakarta.validation.constraints.Future;
	import jakarta.validation.constraints.NotBlank;
	import jakarta.validation.constraints.NotNull;
	import java.time.LocalDate;

public record ReservaRequest (
	    
	    @NotBlank(message = "El nombre del huésped es obligatorio")
	    String huesped,
	    
	    @NotNull(message = "La habitación es obligatoria")
	    Long habitacionId,
	    
	    @NotNull(message = "La fecha de entrada es obligatoria")
	    @Future(message = "La fecha de entrada debe ser futura")
	    LocalDate fechaEntrada,
	    
	    @NotNull(message = "La fecha de salida es obligatoria")
	    @Future(message = "La fecha de salida debe ser futura")
	    LocalDate fechaSalida
	    ){
}
=======
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record ReservaRequest(
    
		@NotBlank(message = "El huésped es requerido")
	    String huesped,

	    @NotNull(message = "La habitación es requerida")
	     Long idHabitacion,

	    @NotNull(message = "La fecha de entrada es requerida")
	    LocalDate fechaEntrada,

	    @NotNull(message = "La fecha de salida es requerida")
	     LocalDate fechaSalida,

	    Integer noches,

	    Double total,

	    @Positive(message="La categoria debe ser positiva")
		Long idEstado
    
    
) {}
>>>>>>> ec5e25c65c39623364a59f5b23f958f0171a875d
