package com.bangez.chat.chat.domain.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ChatDTO {
    private String id;
    private String chatRoomId;
    private String senderId;
    private String receiverId;
    private String message;
    private String timeStamp;

    private String status;
}
