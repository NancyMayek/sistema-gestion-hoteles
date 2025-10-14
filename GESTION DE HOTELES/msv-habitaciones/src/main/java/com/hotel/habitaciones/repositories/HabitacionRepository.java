package com.hotel.habitaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.habitaciones.models.Habitacion;


@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long>{
	boolean existsByNumero(Short numero);
}
