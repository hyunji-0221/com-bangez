package com.bangez.analysis.city_park.repository;

import com.bangez.analysis.city_park.model.CityPark;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityParkRepository extends ReactiveMongoRepository<CityPark, String> {
}
