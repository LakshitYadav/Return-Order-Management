package com.cts.rom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PackagingAndDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PackagingAndDeliveryApplication.class, args);
	}

}
