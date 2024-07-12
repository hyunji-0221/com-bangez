package com.example.demo.common;

import org.springframework.security.core.userdetails.UserDetails;

public interface TokenProvider {
    String generateToken(UserDetails userDetails);
    boolean isTokenValid(String token);

}
