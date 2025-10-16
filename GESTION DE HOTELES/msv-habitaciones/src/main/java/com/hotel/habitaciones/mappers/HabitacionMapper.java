package com.hotel.habitaciones.mappers;

import org.springframework.stereotype.Component;

import com.hotel.commons.dto.HabitacionRequest;
import com.hotel.commons.dto.HabitacionResponse;
import com.hotel.commons.mappers.CommonMapper;
import com.hotel.habitaciones.models.Habitacion;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor 
public class HabitacionMapper extends CommonMapper<HabitacionRequest,HabitacionResponse, Habitacion>{

	@Override
	public HabitacionResponse entityToResponse(Habitacion entity) {
		if(entity==null) return null;			
		return new HabitacionResponse(
			entity.getId(),
			entity.getNumero(),
			entity.getTipo(),
			entity.getDescripcion(),
			entity.getPrecio(),
			entity.getCapacidad(),
			entity.getIdEstado()
		);
	}

	@Override
	public Habitacion requestToEntity(HabitacionRequest request) {
		if(request == null) return null;
		Habitacion habitacion = new Habitacion();
		habitacion.setNumero(request.numero());
		habitacion.setTipo(request.tipo());
		habitacion.setDescripcion(request.descripcion());
		habitacion.setPrecio(request.precio());
		habitacion.setCapacidad(request.capacidad());
		habitacion.setIdEstado(request.idEstado());
		
		return habitacion;
	}

	

	

}
