package com.hotel.reservas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.reservas.models.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{

}
