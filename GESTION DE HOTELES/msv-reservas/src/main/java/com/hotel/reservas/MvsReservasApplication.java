package com.hotel.reservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;

@SpringBootApplication(scanBasePackages = {"com.hotel.reservas","com.hotel.commons"})
@EnableMBeanExport
public class MvsReservasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvsReservasApplication.class, args);
	}

}
