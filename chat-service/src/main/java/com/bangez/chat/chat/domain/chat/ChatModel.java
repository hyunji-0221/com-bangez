package com.bangez.chat.chat.domain.chat;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "chats")
public class ChatModel {
    @Id
    private String id;
    private String chatRoomId;
    private String senderId;
    private String receiverId;
    private String message;
    private String timeStamp;

    private String status; //메시지 상태("전송", "읽음") 구현할 수도 안할수도..
}
