package com.bangez.api.oauth;

import com.bangez.api.oauthVO.ExceptionStatus;
import lombok.Getter;

@Getter
public class LoginException extends RuntimeException {
    private final ExceptionStatus status;

    public LoginException(ExceptionStatus status, String message) {
        super(message);
        this.status = status;
    }

}
