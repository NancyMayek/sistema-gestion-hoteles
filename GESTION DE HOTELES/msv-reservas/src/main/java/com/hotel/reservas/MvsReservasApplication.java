package com.hotel.reservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableMBeanExport;

@SpringBootApplication(scanBasePackages = {"com.hotel.reservas","com.hotel.commons"})
@EnableFeignClients
@EnableDiscoveryClient 
public class MvsReservasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvsReservasApplication.class, args);
	}

}
