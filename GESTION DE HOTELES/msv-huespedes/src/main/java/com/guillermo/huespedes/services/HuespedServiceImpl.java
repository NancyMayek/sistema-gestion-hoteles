package com.guillermo.huespedes.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.guillermo.huespedes.mappers.HuespedMapper;
import com.guillermo.huespedes.models.Huesped;
import com.guillermo.huespedes.repositories.HuespedRepository;
import com.hotel.commons.dto.HuespedRequest;
import com.hotel.commons.dto.HuespedResponse;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class HuespedServiceImpl implements HuespedService{
	
	private final HuespedRepository huespedRepository;
	private final HuespedMapper huespedMapper;
	
	@Override
	public List<HuespedResponse> listar() {
		log.info("Listado de todas las huespedes solicitada");
		return huespedRepository.findAll().stream()
		.map(huespedMapper::entityToResponse).toList();
	}

	@Override
	public HuespedResponse obtenerPorId(Long id) {
		log.info("Buscando huesped con id {}", id);
		Huesped huesped = getHuespedOrThrow(id);
		return huespedMapper.entityToResponse(huesped);
	}

	@Override
	public HuespedResponse insertar(HuespedRequest request) {
		log.info("Insertando nueva Huesped con numero {}", request.nombre());
		
		 if (huespedRepository.existsByEmail(request.email())) {
			 throw new DataIntegrityViolationException("Ya existe un huesped con ese email: " + request.email());
	        }
		 
		 if (huespedRepository.existsByTelefono(request.telefono())) {
			 throw new DataIntegrityViolationException("Ya existe un huesped con ese email: " + request.email());
	        }
		 
		return huespedMapper.entityToResponse(
				huespedRepository.save(huespedMapper.requestToEntity(request))
		);
	}

	@Override
	public HuespedResponse actualizar(HuespedRequest request, Long id) {
		log.info("Buscando huesped con id {}", id);
		Huesped huesped = getHuespedOrThrow(id);
		log.info("Actualizando la huesped con id {}", id);
		huesped.setNombre(request.nombre());
		huesped.setApellido(request.apellido());
		huesped.setEmail(request.email());
		huesped.setTelefono(request.telefono());
		huesped.setIdDocumento(request.idDocumento());
		huesped.setNacionalidad(request.nacionalidad());;
		
		return huespedMapper.entityToResponse(huespedRepository.save(huesped));
	}

	@Override
	public void eliminar(Long id) {
		log.info("Eliminando Huesped con id {}", id);
		Huesped huesped = getHuespedOrThrow(id);
		huespedRepository.delete(huesped);
		log.info("Numero de Huesped eliminada: {}", huesped.getNombre());
	}
	
	private Huesped getHuespedOrThrow(Long id) {
        return huespedRepository.findById(id).orElseThrow(() -> 
            new NoSuchElementException("Huesped no encontrado con el id: " + id)
        );	
	
};
	
}
