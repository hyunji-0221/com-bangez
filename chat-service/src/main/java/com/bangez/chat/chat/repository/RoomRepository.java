package com.bangez.chat.chat.repository;

import com.bangez.chat.chat.domain.room.RoomModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface RoomRepository extends ReactiveMongoRepository<RoomModel,String> {
    Mono<RoomModel> getRoomModelBySenderIdAndReceiverId(String userId, String receiverId);

    Flux<RoomModel> getRoomModelsBySenderId(String userId);

}
