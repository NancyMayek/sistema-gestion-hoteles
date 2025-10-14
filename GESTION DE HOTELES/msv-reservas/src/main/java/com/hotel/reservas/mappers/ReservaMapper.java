package com.hotel.reservas.mappers;

import org.springframework.stereotype.Component;

import com.hotel.commons.dto.ReservaRequest;
import com.hotel.commons.dto.ReservaResponse;
import com.hotel.commons.mappers.CommonMapper;
import com.hotel.reservas.models.Reserva;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ReservaMapper extends CommonMapper<ReservaRequest, ReservaResponse, Reserva> {

    @Override
    public ReservaResponse entityToResponse(Reserva entity) {
        if (entity == null) return null;
        

        return new ReservaResponse (
                entity.getId(),
                entity.getHuesped(),
                entity.getIdHabitacion(),
                entity.getFechaEntrada(),
                entity.getFechaSalida(),
                entity.getNoches(),
                entity.getTotal(),
                entity.getIdEstado()
        );
    }

    @Override
    public Reserva requestToEntity(ReservaRequest request) {
        if (request == null) return null;

        Reserva reserva = new Reserva();
        reserva.setHuesped(request.huesped());
        reserva.setIdHabitacion(request.idHabitacion());
        reserva.setFechaEntrada(request.fechaEntrada());
        reserva.setFechaSalida(request.fechaSalida());
        reserva.setNoches(request.noches());
        reserva.setTotal(request.total());
        reserva.setIdEstado(request.idEstado());
        

        return reserva;
    }
}
