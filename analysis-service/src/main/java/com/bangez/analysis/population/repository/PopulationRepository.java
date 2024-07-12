package com.bangez.analysis.population.repository;

import com.bangez.analysis.population.model.Population;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopulationRepository extends ReactiveMongoRepository<Population, String> {
}
