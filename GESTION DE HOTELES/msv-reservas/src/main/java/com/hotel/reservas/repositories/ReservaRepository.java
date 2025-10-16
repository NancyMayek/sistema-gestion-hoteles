package com.hotel.reservas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.reservas.models.Reserva;
import org.springframework.data.repository.query.Param;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{
	boolean existsByIdHabitacion(@Param("idHabitacion")Long idHabitacion);
	boolean existsByIdHuesped(@Param("idHuesped")Long idHuesped);
}