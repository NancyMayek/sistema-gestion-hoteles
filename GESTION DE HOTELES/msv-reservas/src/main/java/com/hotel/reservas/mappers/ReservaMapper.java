package com.hotel.reservas.mappers;

<<<<<<< HEAD
=======
import org.springframework.stereotype.Component;

>>>>>>> ec5e25c65c39623364a59f5b23f958f0171a875d
import com.hotel.commons.dto.ReservaRequest;
import com.hotel.commons.dto.ReservaResponse;
import com.hotel.commons.mappers.CommonMapper;
import com.hotel.reservas.models.Reserva;

<<<<<<< HEAD
public class ReservaMapper  extends CommonMapper<ReservaRequest, ReservaResponse, Reserva>{

	@Override
	protected ReservaResponse entityToResponse(Reserva entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Reserva requestToEntity(ReservaRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	

=======
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
>>>>>>> ec5e25c65c39623364a59f5b23f958f0171a875d
}
