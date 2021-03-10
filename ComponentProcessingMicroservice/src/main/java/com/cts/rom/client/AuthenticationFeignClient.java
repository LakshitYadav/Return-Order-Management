package com.cts.rom.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.rom.model.AuthenticationResponse;

@FeignClient(name="authenticationFeignClient", url="http://localhost:8084/")
public interface AuthenticationFeignClient {

	@GetMapping(value="/validate")
	AuthenticationResponse getValidity(@RequestHeader("Authorization")String token);
}
