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

    private boolean read; //메시지 상태("안읽음", "읽음") 알림을 위한 필드
}
