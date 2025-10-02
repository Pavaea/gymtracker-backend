package com.gymtracker.backend.service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

    @Service
    public class JwtService {

        private final String SECRET;

        public JwtService(@Value("${jwt.secret}") String secret) {
            this.SECRET = secret;
        }

        private final long EXPIRATION = 1000 * 60 * 60; // 1h

        public String generateToken(String username) {
            return Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                    .signWith(SignatureAlgorithm.HS256, SECRET)
                    .compact();
        }

        public String extractUsername(String token) {
            return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();
        }
    }
