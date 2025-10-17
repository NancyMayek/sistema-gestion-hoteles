package com.hotel.habitaciones.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hotel.commons.clients.ReservaClient;
import com.hotel.commons.dto.HabitacionRequest;
import com.hotel.commons.dto.HabitacionResponse;
import com.hotel.commons.exceptions.EntidadRelacionadaException;
import com.hotel.habitaciones.mappers.HabitacionMapper;
import com.hotel.habitaciones.models.Habitacion;
import com.hotel.habitaciones.repositories.HabitacionRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class HabitacionServiceImpl implements HabitacionService{

	private final HabitacionRepository habitacionRepository;
	private final HabitacionMapper habitacionMapper;
	private final ReservaClient reservaClient;
	
	@Override
	public List<HabitacionResponse> listar() {
		log.info("Listado de todas las habitaciones solicitada");
		return habitacionRepository.findAll().stream()
		.map(habitacionMapper::entityToResponse).toList();
	}

	@Override
	public HabitacionResponse obtenerPorId(Long id) {
		log.info("Buscando habitacion con id {}", id);
		Habitacion habitacion = getHabitacionOrThrow(id);
		return habitacionMapper.entityToResponse(habitacion);
	}

	@Override
	public HabitacionResponse insertar(HabitacionRequest request) {
		log.info("Insertando nueva Habitacion con numero {}", request.numero());
		
		 if (habitacionRepository.existsByNumero(request.numero())) {
			 throw new DataIntegrityViolationException("Ya existe una habitación con el número: " + request.numero());
	        }
		 
		 //Si el usuario puso el id 2 de Ocupado entonces no tiene sentido que es una nueva habitacion y que ya este ocupado
		 if(request.idEstado() == 2) {
			 throw new DataIntegrityViolationException("El estado de una habitacion nueva no puede ser ocupado");
		 }
		
		
		return habitacionMapper.entityToResponse(
				habitacionRepository.save(habitacionMapper.requestToEntity(request))
		);
	}

	@Override
	public HabitacionResponse actualizar(HabitacionRequest request, Long id) {
		log.info("Buscando habitacion con id {}", id);
		Habitacion habitacion = getHabitacionOrThrow(id);
		log.info("Actualizando la habitacion con id {}", id);
		habitacion.setNumero(request.numero());
		habitacion.setTipo(request.tipo());;
		habitacion.setDescripcion(request.descripcion());
		habitacion.setPrecio(request.precio());
		habitacion.setCapacidad(request.capacidad());
		habitacion.setIdEstado(request.idEstado());
		return habitacionMapper.entityToResponse(habitacionRepository.save(habitacion));
	}

	@Override
	public void eliminar(Long id) {
		log.info("Eliminando Habitacion con id {}", id);
		Habitacion habitacion = getHabitacionOrThrow(id);
		if (reservaClient.habitacionPresente(id)) {
			throw new EntidadRelacionadaException("La Habitacion está referenciada en una reserva y no puede eliminarse");
		}
		habitacionRepository.delete(habitacion);
		log.info("Numero de Habitacion eliminada: {}", habitacion.getNumero());
	}
	
	private Habitacion getHabitacionOrThrow(Long id) {
        return habitacionRepository.findById(id).orElseThrow(() -> 
            new NoSuchElementException("Habitacion no encontrado con el id: " + id)
        );
    }
	
	public boolean validarEstado(Long idEstadoPasado, Long idEstadoActualizar) {
		//VALIDAR ESTADOS
		
				//Si es el estado es DISPONIBLE
				if(idEstadoPasado == 1  ) {
					return true; //con Disponible se pueden acceder a todos los estados
				}
				
				
				
				return false;
	}

}
