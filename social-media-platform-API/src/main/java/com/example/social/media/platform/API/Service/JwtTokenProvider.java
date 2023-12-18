package com.example.social.media.platform.API.Service;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    /**
     * Generates a JWT token for the given username.
     *
     * @param username The username for which the token is generated
     * @return The generated JWT token
     */
    public String generateToken(String username) {
        // Implementation to generate a JWT token
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    /**
     * Extracts the username from the given JWT token.
     *
     * @param token The JWT token from which to extract the username
     * @return The username extracted from the token
     */
    public String getUsernameFromToken(String token) {
        // Implementation to extract username from a JWT token
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    /**
     * Validates the given JWT token.
     *
     * @param token The JWT token to validate
     * @return True if the token is valid, false otherwise
     */
    public boolean validateToken(String token) {
        // Implementation to validate a JWT token
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException | MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException e) {
            return false;
        }
    }
}


