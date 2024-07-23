package com.bangez.apigateway.domain.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String email;
    private String password;
}