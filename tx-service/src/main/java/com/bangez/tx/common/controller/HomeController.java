package com.bangez.tx.common.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Log4j2
@RestController
public class HomeController {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @GetMapping("/")
    public String home(){
        log.info("tx home controller");
        return "안녕하세용용가리 tx-service "+formatter.format(LocalDateTime.now());
    }
}
