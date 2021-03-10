package com.cts.rom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ComponentProcessingMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComponentProcessingMicroserviceApplication.class, args);
	}

}
