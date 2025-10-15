package com.mario.oauth.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mario.oauth.models.Rol;
import com.mario.oauth.models.Usuario;

public interface RolRepository extends JpaRepository<Rol, Long>{
	


	Optional<Rol> findByUsername(String username);

	Optional<Usuario> findByNombre(String username);

	
	
	
}
