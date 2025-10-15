package com.hotel.commons.dto;

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