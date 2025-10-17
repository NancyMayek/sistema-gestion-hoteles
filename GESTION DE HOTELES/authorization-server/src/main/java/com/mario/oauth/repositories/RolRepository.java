package com.mario.oauth.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mario.oauth.models.Rol;


@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
	
	Optional<Rol> findByNombre(String nombre);

}
