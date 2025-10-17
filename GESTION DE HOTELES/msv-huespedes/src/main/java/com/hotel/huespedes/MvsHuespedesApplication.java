package com.hotel.huespedes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication(scanBasePackages = {"com.hotel.huespedes", "com.hotel.commons"})
@EnableFeignClients
public class MvsHuespedesApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MvsHuespedesApplication.class, args);
	}

}
