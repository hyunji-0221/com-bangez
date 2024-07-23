package com.example.demo.apartment.repository;


import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.apartment.domain.ApartmentModel;

import reactor.core.publisher.Flux;

@Repository
public interface ApartmentRepository extends ReactiveMongoRepository<ApartmentModel, String> {


    // Flux<ApartmentModel> findByTownAndPrcBetweenAndSpc1BetweenAndTradTpNm(String town, int minPrice, int maxPrice, double minArea, double maxArea, String tradTpNm);

    @Query("{ 'tradTpNm': ?0, 'prc': { $gte: ?1, $lte: ?2 } }")
    Flux<ApartmentModel> findByTradTpNmAndPrcBetween(String tradTpNm, int minPrice, int maxPrice);

    @Query("{ 'prc': { $gte: ?0, $lte: ?1 } }")
    Flux<ApartmentModel> findByPrcBetween(int minPrice, int maxPrice);
}