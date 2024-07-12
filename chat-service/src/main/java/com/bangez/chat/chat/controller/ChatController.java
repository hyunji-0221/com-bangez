package com.bangez.chat.chat.controller;

import com.bangez.chat.chat.domain.chat.ChatModel;
import com.bangez.chat.chat.domain.room.RoomModel;
import com.bangez.chat.chat.service.ChatService;
import com.bangez.chat.common.Messenger;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", allowCredentials = "true")
public class ChatController {

    private final ChatService chatService;

//    @GetMapping(value = "/sse/{chatRoomId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Flux<ServerSentEvent<ChatModel>> streamMessages(@PathVariable("chatRoomId") String chatRoomId, ServerHttpResponse response) {
//        log.info("GetMapping chatRoomId: {}", chatRoomId);
//        response.getHeaders().setContentType(MediaType.TEXT_EVENT_STREAM);
//        response.getHeaders().setCacheControl("no-cache");
//        response.getHeaders().setConnection("keep-alive");
//        return chatService.streamMessages(chatRoomId);
//    }

    @GetMapping(value = "/sse/{chatRoomId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<ChatModel>> streamMessages(@PathVariable("chatRoomId") String chatRoomId,
                                                           ServerWebExchange response) {
        log.info("GetMapping chatRoomId: {}", chatRoomId);
        response.getResponse().getHeaders().setContentType(MediaType.TEXT_EVENT_STREAM);
        response.getResponse().getHeaders().setCacheControl("no-cache");
        response.getResponse().getHeaders().setConnection("keep-alive");
        return chatService.streamMessages(chatRoomId);
    }

    @PostMapping("/save") // 채팅 메시지 전송
    public ResponseEntity<Mono<ChatModel>> sendMessage(@RequestBody ChatModel chatModel) {
        log.info("PostMapping chatModel: {}", chatModel);
        chatService.saveMessage(chatModel).doOnNext(chat -> log.info("chat: {}", chat)).subscribe();
        return ResponseEntity.ok(chatService.saveMessage(chatModel));
    }

}
