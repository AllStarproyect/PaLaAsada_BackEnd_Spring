package org.palaasada.backend.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.palaasada.backend.model.User;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    private final String SECRET_KEY =
            "PalaasadaProyectoIntegradorSecretKey2026";

    private final long TIEMPO_EXPIRACION = 1000 * 60 * 60;

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(
                SECRET_KEY.getBytes(StandardCharsets.UTF_8)
        );
    }

    public String generarToken(User usuario) {

        return Jwts.builder()
                .subject(usuario.getCorreo())
                .claim("rol", usuario.getRol() != null ? usuario.getRol().getNombre() : "CLIENTE")
                .issuedAt(new Date())
                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + TIEMPO_EXPIRACION
                        )
                )
                .signWith(getKey())
                .compact();
    }

    public String obtenerCorreo(String token) {

        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}