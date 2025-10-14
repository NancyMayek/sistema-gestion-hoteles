package com.mario.oauth.dto;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequest(
	
	@NotBlank(message="El username es reuqerido")
	@Size(min=5,max=20,message="El username debe tener entre 5 y 20 caracteres")
	String username,
	
	@NotBlank(message="El password es reuqerido")
	@Size(min=8,message="El password debe tener entre 5 y 20 caracteres")
	String password,
	
	@NotBlank(message="Los Roles son reuqerido")
	@Size(min=1,message="El Usuario debe tener al menos 1 rol")
	Set<String> roles
	
		) {
}
