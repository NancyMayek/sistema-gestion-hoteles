package com.hotel.reservas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.reservas.models.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

}
