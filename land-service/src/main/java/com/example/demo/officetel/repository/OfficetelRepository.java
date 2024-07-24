package com.example.demo.officetel.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.officetel.domain.OfficetelModel;

@Repository
public interface OfficetelRepository extends ReactiveMongoRepository<OfficetelModel, String> {
}