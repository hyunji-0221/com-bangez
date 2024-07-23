package com.bangez.chat.chat.controller;

import com.bangez.chat.chat.domain.chat.ChatModel;
import com.bangez.chat.chat.service.impl.ChatServiceImpl;
import com.bangez.chat.common.Messenger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor

//@RequestMapping("/chat")
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", allowCredentials = "true")
public class ChatController {

    private final ChatServiceImpl chatServiceImpl;

    @GetMapping(path = "/sse/{roomId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<ChatModel>> connectSSE(@PathVariable("roomId") String roomId) {
        log.info("커넥트 chat controller streamMessages");
        String userId = "1";
        return chatServiceImpl.connectChat(roomId);
//                .doOnSubscribe(subscription -> chatService.markMessagesAsRead(roomId, userId).subscribe());
    }

    @PostMapping("/save") // 채팅 메시지 전송
    public ResponseEntity<Mono<ChatModel>> sendMessage(@RequestBody ChatModel chatModel) {
        log.info("PostMapping chatModel: {}", chatModel);
        return ResponseEntity.ok(chatServiceImpl.saveMessage(chatModel));
    }

    @GetMapping("/read/{roomId}/{userId}")
    public ResponseEntity<Mono<Messenger>> markMessageRead(@PathVariable("roomId") String roomId,@PathVariable("userId") String userId){
        log.info("챗컨트롤러의 마크메세지리드");
        return ResponseEntity.ok(chatServiceImpl.markMessageRead(roomId, userId));
    }

    @GetMapping(value = "/notifications/{userId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<ChatModel>> connectNotification(@PathVariable("userId") String userId) {
        log.info("connectNotification controller");
        return chatServiceImpl.connectionNotification(userId);
    }

}
