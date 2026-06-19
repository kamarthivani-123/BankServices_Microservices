package com.bank.auth_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.auth_service.dto.LoginRequest;
import com.bank.auth_service.dto.LoginResponse;
import com.bank.auth_service.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	 private final AuthService authService;

	    public AuthController(AuthService authService) {
	        this.authService = authService;
	    }

	    @PostMapping("/login")
	    public LoginResponse login(@RequestBody LoginRequest request) {

	        String token = authService.login(
	                request.getUsername(),
	                request.getPassword()
	        );

	        return new LoginResponse(token);
	    }

}
