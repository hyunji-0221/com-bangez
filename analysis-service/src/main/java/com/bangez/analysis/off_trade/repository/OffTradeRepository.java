package com.bangez.analysis.off_trade.repository;

import com.bangez.analysis.off_trade.model.OffTrade;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffTradeRepository extends ReactiveMongoRepository<OffTrade, String> {
}
