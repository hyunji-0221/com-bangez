package com.bangez.chat.chat.domain.room;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class RoomDTO {

    private String id;
    private String roomTitle;

    private String createDate;

}
