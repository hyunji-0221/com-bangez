package com.bangez.analysis.officetel_rent.controller;

import com.bangez.analysis.officetel_rent.repository.impl.OfficetelRentDAORepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class OfficetelRentRouter {
    private final OfficetelRentDAORepositoryImpl repository;

    public Mono<?> execute(String select, String date){

        return switch (select){
            case "1" -> repository.plotGraphAvgCostByDate();
            case "2" -> repository.plotGraphSaleCountByDate();
            case "3" -> repository.plotGraphSalesCountByRegionForMonth(date);
            default -> null;
        };
    }
}
