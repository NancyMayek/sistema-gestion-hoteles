	package com.mario.oauth.services;
	import java.util.NoSuchElementException;
	import java.util.Set;
	import java.util.stream.Collectors;
	
	import org.springframework.security.crypto.password.PasswordEncoder;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;
	
	import com.mario.oauth.dto.UsuarioRequest;
	import com.mario.oauth.dto.UsuarioResponse;
	import com.mario.oauth.models.Rol;
	import com.mario.oauth.models.Usuario;
	import com.mario.oauth.repositories.UsuarioRepository;
	
	import lombok.AllArgsConstructor;
	
	@Service
	@Transactional
	@AllArgsConstructor
	public class UsuarioServiceImpl implements UsuarioService {

	    private final UsuarioRepository usuarioRepository;
	    private final PasswordEncoder passwordEncoder;

	    @Override
	    @Transactional(readOnly = true)
	    public Set<UsuarioResponse> listarUsuarios() {
	        return usuarioRepository.findAll().stream()
	                .map(usuario -> new UsuarioResponse(
	                        usuario.getUsername(),
	                        usuario.getRoles().stream()
	                                .map(Rol::getNombre)
	                                .collect(Collectors.toSet())))
	                .collect(Collectors.toSet());
	    }

	    @Override
	    public UsuarioResponse crearUsuario(UsuarioRequest request) {
	        if (usuarioRepository.findByUsername(request.username()).isPresent()) {
	            throw new IllegalArgumentException("El usuario " + request.username() + " ya está registrado");
	        }

	      

	        Usuario usuario = new Usuario();
	        usuario.setUsername(request.username());
	        usuario.setPassword(passwordEncoder.encode(request.password()));
	     

	        Usuario saved = usuarioRepository.save(usuario);

	        return new UsuarioResponse(
	                saved.getUsername(),
	                saved.getRoles().stream().map(Rol::getNombre).collect(Collectors.toSet())
	        );
	    }

	    @Override
	    public UsuarioResponse eliminarUsuario(String username) {
	        Usuario usuario = usuarioRepository.findByUsername(username)
	                .orElseThrow(() -> new NoSuchElementException("No se encontró el usuario: " + username));

	        usuarioRepository.delete(usuario);

	        return new UsuarioResponse(
	                usuario.getUsername(),
	                usuario.getRoles().stream().map(Rol::getNombre).collect(Collectors.toSet())
	        );
	    }
}