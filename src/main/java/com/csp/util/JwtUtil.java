package com.csp.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtil {
    private final Key key;

    public JwtUtil() {

        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }

    public String generateToken(String email, String userType) {
        return Jwts.builder()
                .setSubject(email)
                .claim("userType", userType) 
                .signWith(key)
                .compact();
    }
}