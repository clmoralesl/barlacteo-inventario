package com.bar_lacteo.inventario.Autenticacion;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // Debe ser la misma clave secreta que en el microservicio autenticación
    private static final String SECRET = "b8e2c2e5f7a1d4c9e3b6a7f8c1d2e3f4b5c6a7d8e9f0b1c2d3e4f5a6b7c8d9e0b1c2d3e4f5a6b7c8d9e0f1a2b3c4d5";
    private final Key SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isTokenExpired(String token) {
        Date expiration = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }

    public boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }
}