package com.mario.oauth.services;

import java.util.Set;

import com.mario.oauth.dto.UsuarioRequest;
import com.mario.oauth.dto.UsuarioResponse;

public interface UsuarioService {
	Set<UsuarioResponse> listarUsuarios();
	
	UsuarioResponse crearUsuario(UsuarioRequest request);
	

	UsuarioResponse eliminarUsuario(String username);
	
	

}
