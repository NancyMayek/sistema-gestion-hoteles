package com.guillermo.huespedes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication(scanBasePackages = {"com.guillermo.huespedes", "com.guillermo.commons"})
public class MvsHuespedesApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MvsHuespedesApplication.class, args);
	}

}
