package com.bangez.chat.chat.service;

import com.bangez.chat.chat.domain.room.RoomModel;
import com.bangez.chat.common.Messenger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RoomService {
    Mono<RoomModel> openRoom(String userId, String receiverId);

    Flux<RoomModel> getRoomList(String userId);

    Mono<Messenger> deleteRoom(String roomId);
}
