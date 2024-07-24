package com.bangez.analysis.officetel_rent.repository.impl;

import com.bangez.analysis.officetel_rent.model.OfficetelRent;
import com.bangez.analysis.officetel_rent.repository.OfficetelRentDAORepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class OfficetelRentDAORepositoryImpl implements OfficetelRentDAORepository {

    private final ReactiveMongoOperations operations;

    public Mono<Map<String, Long>> plotGraphAvgCostByDate() {
        Criteria criteria = new Criteria();

        Query query = new Query(criteria);
        query.fields().include("contract_date").include("security_deposit");

        return operations.find(query, OfficetelRent.class)
                .collect(Collectors.groupingBy(i->i.getContractDate(),
                        Collectors.collectingAndThen(Collectors.averagingLong(i->i.getSecurityDeposit()), i-> i.longValue())));
    }

    public Mono<Map<String,Long>> plotGraphSaleCountByDate() {
        Criteria criteria = new Criteria();
        Query query = new Query(criteria);
        query.fields().include("contract_date");

        return operations.find(query, OfficetelRent.class)
                .flatMap(i -> Mono.just(OfficetelRent.builder()
                        .contractDate(i.getContractDate().substring(0, 6))
                        .build()))
                .collect(Collectors.groupingBy(i->i.getContractDate(), Collectors.counting()));

    }

    public Mono<Map<String,Long>> plotGraphSalesCountByRegionForMonth(String date) {
        Criteria criteria = Criteria.where("contract_date").regex("^" + date);
        Query query = new Query(criteria);
        query.fields().include("contract_date").include("ward");

        return operations.find(query, OfficetelRent.class)
                .flatMap(i -> Mono.just(OfficetelRent.builder()
                        .contractDate(i.getContractDate().substring(0, 6))
                        .ward(i.getWard())
                        .build()))
                .collect(Collectors.groupingBy(i-> i.getContractDate(), Collectors.counting()));
    }
}
