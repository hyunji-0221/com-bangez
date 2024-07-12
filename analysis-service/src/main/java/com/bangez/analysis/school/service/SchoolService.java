package com.bangez.analysis.school.service;

import com.bangez.analysis.school.model.School;
import reactor.core.publisher.Flux;

public interface SchoolService {

    public Flux<School> importCSV();
}
