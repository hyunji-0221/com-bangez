package com.bangez.chat.chat.controller;


import com.bangez.chat.chat.domain.room.RoomModel;
import com.bangez.chat.chat.service.impl.RoomServiceImpl;
import com.bangez.chat.common.Messenger;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
//@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomServiceImpl roomServiceImpl;

    @GetMapping(value = "/open-room/{userId}/{receiverId}")
    public Mono<RoomModel> test(@PathVariable("userId") String userId,
                                @PathVariable("receiverId")String receiverId) {
        log.info("RoomController userId / receiverId: {} / {}",userId,receiverId);
        return roomServiceImpl.openRoom(userId,receiverId);
    }

    @GetMapping(value = "/get-room-list/{userId}")
    public Flux<RoomModel> getRoomList(@PathVariable("userId") String userId) {
        log.info("userId: {}",userId);
        return roomServiceImpl.getRoomList(userId);
    }

    @DeleteMapping(value = "/delete-room/{roomId}")
    public Mono<Messenger> deleteRoom(@PathVariable("roomId") String roomId) {
        log.info("roomId: {}",roomId);
        return roomServiceImpl.deleteRoom(roomId);
    }

}
