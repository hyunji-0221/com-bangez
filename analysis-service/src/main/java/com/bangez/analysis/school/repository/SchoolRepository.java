package com.bangez.analysis.school.repository;

import com.bangez.analysis.school.model.School;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends ReactiveMongoRepository<School, String> {
}
