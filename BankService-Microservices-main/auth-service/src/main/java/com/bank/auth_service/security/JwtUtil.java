package com.bank.auth_service.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	 private final String SECRET = "mysecretkey";

	    public String generateToken(String username, String role) {

	        return Jwts.builder()
	                .setSubject(username)
	                .claim("role", role)
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
	                .signWith(SignatureAlgorithm.HS256, SECRET)
	                .compact();
	    }

}
