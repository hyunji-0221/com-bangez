package com.bangez.analysis.apt_trade.repository;

import reactor.core.publisher.Mono;

import java.util.Map;

public interface AptTradeDAORepository {

    Mono<Map<String, Long>> plotGraphAvgCostByDate();

    Mono<Map<String,Long>> plotGraphSaleCountByDate();

    Mono<Map<String,Long>> plotGraphSalesCountByRegionForMonth(String date);

    Mono<Map<Long, Long>> plotGraphCostByArea();
}