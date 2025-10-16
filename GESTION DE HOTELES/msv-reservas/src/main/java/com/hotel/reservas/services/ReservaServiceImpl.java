package com.hotel.reservas.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		log.info("Actualizando Proveedor con id {}", id);
		
		reserva.setIdHuesped(request.idHuesped());
		reserva.setIdHabitacion(request.idHabitacion());       
		reserva.setFechaEntrada(request.fechaEntrada());
		reserva.setFechaSalida(request.fechaSalida());
		reserva.setNoches(request.noches());
	    reserva.setTotal(request.total());
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


