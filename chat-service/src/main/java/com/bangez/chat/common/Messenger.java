package com.bangez.chat.common;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Messenger {
    private String message;
    private String status;
}
