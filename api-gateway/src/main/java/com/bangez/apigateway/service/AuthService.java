package com.bangez.apigateway.service;

import com.bangez.apigateway.domain.dto.LoginDTO;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

public interface AuthService {
    Mono<ServerResponse> localLogin(LoginDTO dto);
    Mono<ServerResponse> refresh(String refreshToken);
    Mono<ServerResponse> logout(String refreshToken);
}