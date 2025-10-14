package com.guillermo.huespedes.repositories;

import com.guillermo.huespedes.models.Huesped;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HuespedRepository extends JpaRepository<Huesped, Long> {
    
    boolean existsByEmail(String email);
    boolean existsByTelefono(String telefono);
}