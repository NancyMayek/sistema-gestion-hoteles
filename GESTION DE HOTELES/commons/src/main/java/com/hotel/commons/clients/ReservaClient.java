package com.hotel.commons.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msv-reservas")
public interface ReservaClient {
	
	@GetMapping("/id-huesped/{id}")
	boolean huespedPresente(@PathVariable Long id);
	
	@GetMapping("/id-habitacion/{id}")
	boolean habitacionPresente(@PathVariable Long id);
	
	@GetMapping("/id-reserva/{id}")
	boolean reservaPresente(@PathVariable Long id);

}
