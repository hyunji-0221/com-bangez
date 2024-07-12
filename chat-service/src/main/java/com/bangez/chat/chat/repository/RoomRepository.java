package com.bangez.chat.chat.repository;

import com.bangez.chat.chat.domain.room.RoomModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends ReactiveMongoRepository<RoomModel,String> {
}
