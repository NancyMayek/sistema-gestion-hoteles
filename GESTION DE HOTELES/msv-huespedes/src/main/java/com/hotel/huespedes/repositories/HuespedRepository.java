package com.hotel.huespedes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.huespedes.models.Huesped;

@Repository
public interface HuespedRepository extends JpaRepository<Huesped, Long> {
    
    boolean existsByEmail(String email);
    boolean existsByTelefono(String telefono);
}