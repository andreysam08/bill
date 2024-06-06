package ru.example.demo.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WebSecurity {

    public boolean checkClientId(Authentication authentication, String requiredClientId) {
        if (authentication.getPrincipal() instanceof Jwt) {
            Jwt jwt = (Jwt) authentication.getPrincipal();
            List<String> audience = jwt.getAudience();
            return audience.contains(requiredClientId);
        }
        return false;
    }
}