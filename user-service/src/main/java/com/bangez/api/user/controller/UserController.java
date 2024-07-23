package com.bangez.api.user.controller;

import com.bangez.api.common.MessengerVO;
import com.bangez.api.user.domain.UserDTO;
import com.bangez.api.user.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserServiceImpl service;

    @PostMapping("/add")
    public ResponseEntity<MessengerVO> save(@RequestBody UserDTO dto){
        log.info("입력받은 정보 : {}", dto);
        return ResponseEntity.ok(service.save(dto));
    }

}