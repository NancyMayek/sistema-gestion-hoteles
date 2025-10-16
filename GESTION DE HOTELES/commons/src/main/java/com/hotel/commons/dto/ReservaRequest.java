package com.hotel.commons.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record ReservaRequest(
    
		@NotNull(message = "El huésped es requerido")
	    Long idHuesped,

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