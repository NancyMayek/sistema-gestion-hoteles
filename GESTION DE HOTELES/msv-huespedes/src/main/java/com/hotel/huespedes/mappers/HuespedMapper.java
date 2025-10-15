package com.hotel.huespedes.mappers;

import org.springframework.stereotype.Component;

import com.hotel.commons.dto.HuespedRequest;
import com.hotel.commons.dto.HuespedResponse;
import com.hotel.commons.mappers.CommonMapper;
import com.hotel.huespedes.models.Huesped;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class HuespedMapper extends CommonMapper<HuespedRequest, HuespedResponse, Huesped>{

	@Override
	public HuespedResponse entityToResponse(Huesped entity) {
		if (entity== null) return null;
	return new HuespedResponse (
			entity.getId(),
			entity.getNombre(),
			entity.getApellido(),
			entity.getEmail(),
			entity.getTelefono(),
			entity.getIdDocumento(),
			entity.getNacionalidad()
			);	
		
		
	}

	@Override
	public Huesped requestToEntity(HuespedRequest request) {
		if (request == null) return null;
		Huesped huesped = new Huesped();
			huesped.setNombre(request.nombre());
			huesped.setApellido(request.apellido());
			huesped.setEmail(request.email());
			huesped.setTelefono(request.telefono());
			huesped.setIdDocumento(request.idDocumento());
			huesped.setNacionalidad(request.nacionalidad());
		return huesped;		
	}
	

}
