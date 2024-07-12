package com.bangez.analysis.off_rent.repository;

import com.bangez.analysis.off_rent.model.OffRent;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffRentRepository extends ReactiveMongoRepository<OffRent, String> {
}
