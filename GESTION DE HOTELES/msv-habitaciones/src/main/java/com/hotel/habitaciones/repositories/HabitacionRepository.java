package com.hotel.habitaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotel.habitaciones.models.Habitacion;

import feign.Param;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long>{
	boolean existsByIdCategoria(Long id); 

	@Query(nativeQuery =  true, value = "SELECT COUNT(*) FROM PRODUCTO_PROVEEDOR WHERE ID = :idProveedor")
	int existsByIdProveedor(@Param("idProveedor") Long idProveedor);
}
