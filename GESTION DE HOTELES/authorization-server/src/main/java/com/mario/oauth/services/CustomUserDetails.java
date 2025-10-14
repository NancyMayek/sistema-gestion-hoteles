package com.mario.oauth.services;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mario.oauth.models.Usuario;
import com.mario.oauth.repositories.UsuarioRepository;

public class CustomUserDetails implements UserDetailsService{
	
	private final UsuarioRepository usuarioRepository = null;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado en BD"));
		
		return new User(
				usuario.getUsername(),
				usuario.getPassword(),
				usuario.getRoles()
				.stream()
				.map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
				.collect(Collectors.toSet())
	
	);
		}

	
	

}
