package com.bangez.chat.chat.service;

import com.bangez.chat.chat.domain.chat.ChatModel;
import com.bangez.chat.common.Messenger;
import org.springframework.http.codec.ServerSentEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ChatService {
    Flux<ServerSentEvent<ChatModel>> connectChat(String roomId) ;

    Mono<ChatModel> saveMessage(ChatModel chatModel);

    Mono<Messenger> markMessageRead(String roomId, String userId);

    Flux<ServerSentEvent<ChatModel>> connectionNotification(String userId);
}
