package org.BTapp.BudgetTracker.model.data;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

@Configuration
public class JwtConfig {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private int jwtExpiration;

    @Bean
    public SecretKey secretKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    @Bean
    public SignatureAlgorithm signatureAlgorithm() {
        return SignatureAlgorithm.HS512;
    }

    @Bean
    public int jwtExpiration() {
        return jwtExpiration;
    }
}
