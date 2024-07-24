package com.bangez.analysis.school.service;

import com.bangez.analysis.school.model.School;
import com.bangez.analysis.school.model.SchoolDto;
import reactor.core.publisher.Mono;

import java.util.List;

public interface SchoolService {

    Mono<List<SchoolDto>> findAll();

    default Mono<SchoolDto> documentToDto(School document) {
        SchoolDto dto = SchoolDto.builder()
                .address(document.getAddress())
                .homepage(document.getHomepage())
                .schoolName(document.getSchoolName())
                .schoolType(document.getSchoolType())
                .build();
        return Mono.just(dto);
    }

    default Mono<School> dtoToDocument(SchoolDto dto) {

        School school = School.builder()
                .address(dto.getAddress())
                .homepage(dto.getHomepage())
                .schoolName(dto.getSchoolName())
                .schoolType(dto.getSchoolType())
                .build();
        return Mono.just(school);

    }
}