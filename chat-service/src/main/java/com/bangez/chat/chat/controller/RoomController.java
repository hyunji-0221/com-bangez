package com.bangez.chat.chat.controller;


import com.bangez.chat.chat.domain.room.RoomModel;
import com.bangez.chat.chat.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", allowCredentials = "true")
public class RoomController {
    private final RoomService roomService;

    @GetMapping(value = "/addRoomId/{userId}/{receiverId}")
    public Mono<RoomModel> addRoomId(@RequestHeader("Authorization") String token,//기능 추가되면 userId 치우기
                                     @PathVariable("userId") String userId,
                                     @PathVariable("receiverId")String receiverId) {
        log.info("userId: {}",userId);
        return roomService.addRoomId(userId);
    }
}
