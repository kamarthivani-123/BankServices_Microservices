package com.bank.auth_service.service;

import  com.bank.auth_service.entity.User;
import com.bank.auth_service.repository.UserRepository;
import com.bank.auth_service.security.JwtUtil;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

	 private final UserRepository userRepository;
	    private final JwtUtil jwtUtil;
	    private final PasswordEncoder passwordEncoder;

	    public AuthService(UserRepository userRepository,
	                       JwtUtil jwtUtil,
	                       PasswordEncoder passwordEncoder) {

	        this.userRepository = userRepository;
	        this.jwtUtil = jwtUtil;
	        this.passwordEncoder = passwordEncoder;
	    }

public String login(String username, String password) {

    User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found"));

    if (!passwordEncoder.matches(password, user.getPassword())) {
        throw new RuntimeException("Invalid password");
    }

    return jwtUtil.generateToken(user.getUsername(), user.getRole());

	

}
}
