package com.bangez.chat.chat.service;

import com.bangez.chat.chat.domain.room.RoomModel;
import com.bangez.chat.chat.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


@Slf4j
@Service
@RequiredArgsConstructor
public class RoomService {
    LocalDateTime time = LocalDateTime.now(ZoneId.of("Asia/Seoul"));

    private final RoomRepository roomRepository;
    public Mono<RoomModel> addRoomId(String userId) {
        return roomRepository.save(RoomModel.builder()
                .roomTitle("test1")
                .createDate(time)
                .build());
    }
}
