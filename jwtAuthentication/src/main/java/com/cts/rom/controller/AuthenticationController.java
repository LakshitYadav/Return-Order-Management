package com.cts.rom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.rom.exception.BadCredentialException;
import com.cts.rom.model.AuthenticationRequest;
import com.cts.rom.model.AuthenticationResponse;
import com.cts.rom.service.JwtUtil;
import com.cts.rom.service.MyUserDetailsService;
import com.cts.rom.service.ValidateService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AuthenticationController {


	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private ValidateService validateService;
	

	//Rest endpoint
	/*
	 * @RequestMapping({ "/hello" }) public String firstPage() { return
	 * "Hello World"; }
	 */
	
	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws BadCredentialException {

		log.info("Login Authenticating");
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new BadCredentialException();
		}



		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt,true));
	}
	
	
	  @GetMapping("/validate") 
	  public AuthenticationResponse getValidity(@RequestHeader("Authorization") final String token) {
		  
			/*
			 *  validating token
			 *  extraction from authorization header>> check the validity of token>>
			 *  return an athenticationResponse Instance with two attributes
			 *  String jwtToken	, Boolean valid;

			 *  
			 *  */
	  
		  log.info("Validate token");
		  return validateService.validate(token); 
	  }
	 

}
	

