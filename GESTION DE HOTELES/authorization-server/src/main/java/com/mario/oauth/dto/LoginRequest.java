package com.mario.oauth.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
	
	@NotBlank(message="El username es reuqerido")
	String username,
	
	@NotBlank(message="El password es reuqerido")
	String password
	) {}
