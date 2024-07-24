package com.bangez.analysis.apt_rent.controller;

import com.bangez.analysis.apt_rent.repository.impl.AptRentDAORepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AptRentRouter {

    private final AptRentDAORepositoryImpl repository;

    public Mono<?> execute(String select, String date){

        return switch (select){
            case "1" -> repository.plotGraphAvgCostByDate();
            case "2" -> repository.plotGraphSaleCountByDate();
            case "3" -> repository.plotGraphSalesCountByRegionForMonth(date);

            default -> null;
        };
    }
}