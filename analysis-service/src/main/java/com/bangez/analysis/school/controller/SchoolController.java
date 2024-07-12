package com.bangez.analysis.school.controller;

import com.bangez.analysis.school.model.School;
import com.bangez.analysis.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@Log4j2
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/school")
public class SchoolController {
    private final SchoolService service;

    @PostMapping(path = "/first")
    public String importCSV() {
        service.importCSV();
        return "성공이닷!";

    }
}