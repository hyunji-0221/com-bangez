package com.bangez.api.oauthDomain;

import lombok.Data;

@Data
public class LoginDTO {
    private String email;
    private String password;
}