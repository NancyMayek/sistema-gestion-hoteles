package com.hotel.reservas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

import com.hotel.reservas.models.Reserva;

=======
import org.springframework.stereotype.Repository;

import com.hotel.reservas.models.Reserva;

@Repository
>>>>>>> ec5e25c65c39623364a59f5b23f958f0171a875d
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

}
