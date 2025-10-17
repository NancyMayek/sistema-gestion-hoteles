package com.hotel.reservas.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.commons.clients.HabitacionClient;
import com.hotel.commons.clients.HuespedClient;
import com.hotel.commons.dto.ReservaRequest;
import com.hotel.commons.dto.ReservaResponse;
import com.hotel.reservas.mappers.ReservaMapper;
import com.hotel.reservas.models.Reserva;
import com.hotel.reservas.repositories.ReservaRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ReservaServiceImpl implements ReservaServices {

    private final ReservaRepository reservaRepository;
    private final ReservaMapper reservaMapper;
    private final HuespedClient huespedClient;
    private final HabitacionClient habitacionClient;
    
    @Override
    @Transactional(readOnly = true)
    public List<ReservaResponse> listar() {
        log.info("Listado de todas las reservas solicitadas");
        return reservaRepository.findAll().stream()
                .map(reservaMapper::entityToResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ReservaResponse obtenerPorId(Long id) {
    	log.info("Buscando Reserva con id {}", id);
		Reserva reserva = getReservaOrThrow(id);
		return reservaMapper.entityToResponse(reserva);
    }

    private Reserva getReservaOrThrow(Long id) {
    	return reservaRepository.findById(id).orElseThrow(() -> 
        new NoSuchElementException("Reserva no encontrada con el id: " + id)
    );
	}

	@Override
    public ReservaResponse insertar(ReservaRequest request) {
        log.info("Insertando nueva reserva para huésped: {}", request.idHuesped());
        
      
		return reservaMapper.entityToResponse(
		reservaRepository.save(reservaMapper.requestToEntity(request)));
       
    }

    @Override
    public ReservaResponse actualizar(ReservaRequest request, Long id) {
    	log.info("Buscando Reserva con id {}", id);
		Reserva reserva = getReservaOrThrow(id);
		log.info("Actualizando Reserva con id {}", id);
		
		//Validamos si existen huespedes y habitacion
		if(huespedClient.obtenerHuespedPorId(request.idHuesped()) == null) {
			throw new NoSuchElementException("No existe el Huesped con id" + request.idHuesped());
		}
		reserva.setIdHuesped(request.idHuesped());
		
		if(habitacionClient.obtenerHabitacionPorId(request.idHabitacion()) == null) {
			throw new NoSuchElementException("No existe el Habitacion con id" + request.idHabitacion());
		}
		reserva.setIdHabitacion(request.idHabitacion());  
		
		//Validamos fechas
		LocalDate hoy = LocalDate.now();
		 if (request.fechaEntrada().isBefore(hoy)) {
		        throw new IllegalArgumentException("La fecha de entrada debe ser hoy o una fecha futura.");
		 }
		
		 if (!request.fechaSalida().isAfter(request.fechaEntrada()) || request.fechaSalida().isBefore(request.fechaEntrada())) {
		        throw new IllegalArgumentException("La fecha de salida debe ser posterior a la fecha de entrada.");
		 }
		reserva.setFechaEntrada(request.fechaEntrada());
		reserva.setFechaSalida(request.fechaSalida());
		
		//Calcular noches
		Integer noches = (int) ChronoUnit.DAYS.between(request.fechaEntrada(), request.fechaSalida());
		reserva.setNoches(noches);
		
		//Calculamos total
		Double precioHabitacion = habitacionClient.obtenerHabitacionPorId(request.idHabitacion()).precio();
		Double total = precioHabitacion * request.noches();
	    reserva.setTotal(total);
	    
	    reserva.setIdEstado(request.idEstado());
	        
		return reservaMapper.entityToResponse(reservaRepository.save(reserva));
        }


    @Override
    public void eliminar(Long id) {
    	log.info("Eliminando Reserva con id {}", id);
		Reserva reserva = getReservaOrThrow(id);
		reservaRepository.delete(reserva);
		log.info("reserva eliminada: {}", reserva.getId());
    }
    
    @Override
	public boolean habitacionPresente(Long id) {
		return reservaRepository.existsByIdHabitacion(id);
	}
    
    @Override
	public boolean huespedPresente(Long id) {
		return reservaRepository.existsByIdHuesped(id);
	}

}


