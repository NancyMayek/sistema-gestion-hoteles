package com.hotel.commons.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class HuespedRequest {
	
	@NotBlank(message = "El nombre es obligatorio.")
    @Size(min = 10, message = "El nombre debe tener al menos 10 caracteres.")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio.")
    @Size(min = 10, message = "El apellido debe tener al menos 10 caracteres.")
    private String apellido;

    @NotBlank(message = "El email es obligatorio.")
    @Email(message = "Debe ingresar un correo electrónico válido.")
    private String email;

    @NotBlank(message = "El teléfono es obligatorio.")
    @Pattern(regexp = "^[0-9]{10}$", message = "El teléfono debe tener exactamente 10 dígitos.")
    private String telefono;

    @NotBlank(message = "El documento es obligatorio.")
    @Pattern(regexp = "^(INE|Pasaporte)$", message = "El documento debe ser 'INE' o 'Pasaporte'.")
    private String documento;

    @NotBlank(message = "La nacionalidad es obligatoria.")
    @Size(max = 50, message = "La nacionalidad no debe exceder los 50 caracteres.")
    private String nacionalidad;

}
