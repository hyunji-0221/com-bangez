package com.bangez.chat.chat.service;

import com.bangez.chat.chat.domain.chat.ChatModel;
import com.bangez.chat.chat.domain.room.RoomModel;
import com.bangez.chat.chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatService {
//    private final KafkaTemplate<String, String> kafkaTemplate;

//    @KafkaListener(topics = "chat_topic", groupId = "group_id")
//    public void listen(String message) {
//        // Kafka에서 수신한 메시지를 MongoDB에 저장
//        Chat chat = new Chat();
//        chat.setMessage(message);
//        // 채팅 메시지의 다른 필드도 설정
//        chatRepository.save(chat).subscribe();
//    }

    private final ChatRepository chatRepository;

    /*public Flux<ServerSentEvent<ChatModel>> streamMessages(String chatRoomId) {
        return chatRepository.findByChatRoomId(chatRoomId)
                .map(i -> ServerSentEvent.<ChatModel>builder()
                        .id(chatRoomId)
                        .data(i)
                        .event("receive")
                        .retry(Duration.ofMillis(1000))
                        .build()
                )
                .delayElements(Duration.ofMillis(100));
    }*/

    public Flux<ServerSentEvent<ChatModel>> streamMessages(String chatRoomId) {
        log.info("chat service streamMessages");
        return chatRepository.findByChatRoomId(chatRoomId)
                .map(model -> ServerSentEvent.<ChatModel>builder()
                        .id(chatRoomId)
                        .data(model)
                        .event("send")
                        .retry(Duration.ofMillis(1000))
                        .build()
                );
    }

    public Mono<ChatModel> saveMessage(ChatModel chatModel) {
        log.info("service: {}", chatModel);
        return chatRepository.save(ChatModel.builder()
                .chatRoomId(chatModel.getChatRoomId())
                .timeStamp(Instant.now().toString())
                .status(chatModel.getStatus())
                .message(chatModel.getMessage())
                .receiverId(chatModel.getReceiverId())
                .senderId(chatModel.getSenderId())
                .build());
    }


}
