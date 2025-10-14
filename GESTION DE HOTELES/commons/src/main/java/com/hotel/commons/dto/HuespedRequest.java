package com.hotel.commons.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record HuespedRequest (
		@NotBlank(message = "El nombre es obligatorio.")
	    @Size(min = 10, message = "El nombre debe tener al menos 10 caracteres.")
	    String nombre,

	    @NotBlank(message = "El apellido es obligatorio.")
	    @Size(min = 10, message = "El apellido debe tener al menos 10 caracteres.")
	    String apellido,

	    @NotBlank(message = "El email es obligatorio.")
	    @Email(message = "Debe ingresar un correo electrónico válido.")
	    String email,
	    
	    @NotBlank(message = "El teléfono es obligatorio.")
	    @Pattern(regexp = "^[0-9]{10}$", message = "El teléfono debe tener exactamente 10 dígitos.")
	    String telefono,

	    @NotNull(message = "El documento es obligatorio.")
	    Long idDocumento,

	    @NotBlank(message = "La nacionalidad es obligatoria.")
	    @Size(max = 50, message = "La nacionalidad no debe exceder los 50 caracteres.")
	    String nacionalidad
)

{}
