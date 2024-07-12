package com.example.demo.security.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("tokens")
public class TokenModel {

    @Id
    private String tokenId;
    private String refreshToken;
    private String email;
    private Date expiration;

    @Override
    public String toString() {
        return "RefreshTokenModel [tokenId=" + tokenId +
                ", refreshToken=" + refreshToken +
                ", email=" + email +
                ", expiration=" + expiration +
                "]";
    }


}