package com.bangez.analysis.school.service.impl;

import com.bangez.analysis.school.model.SchoolDto;
import com.bangez.analysis.school.repository.SchoolRepository;
import com.bangez.analysis.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository repository;

    public Mono<List<SchoolDto>> findAll(){
        return repository.findAll().flatMap(i-> documentToDto(i)).collectList();
    }

}
