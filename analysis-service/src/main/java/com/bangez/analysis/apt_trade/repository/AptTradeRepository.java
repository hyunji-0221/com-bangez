package com.bangez.analysis.apt_trade.repository;

import com.bangez.analysis.apt_trade.model.AptTrade;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AptTradeRepository extends ReactiveMongoRepository<AptTrade, String> {
}
