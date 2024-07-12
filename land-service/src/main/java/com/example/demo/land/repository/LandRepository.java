package com.example.demo.land.repository;


import com.example.demo.land.domain.LandModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandRepository extends ReactiveMongoRepository<LandModel, String> {
}