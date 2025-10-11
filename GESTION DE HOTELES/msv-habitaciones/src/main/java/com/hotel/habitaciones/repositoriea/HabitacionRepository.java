package com.hotel.habitaciones.repositoriea;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.habitaciones.models.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Long>{
	
}
