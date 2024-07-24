package com.bangez.analysis.apt_trade.repository.impl;

import com.bangez.analysis.apt_trade.model.AptTrade;
import com.bangez.analysis.apt_trade.repository.AptTradeDAORepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class AptTradeDAORepositoryImpl implements AptTradeDAORepository {
    private final ReactiveMongoOperations operations;

    public Mono<Map<String, Long>> plotGraphAvgCostByDate() {
        Criteria criteria = new Criteria();

        Query query = new Query(criteria);
        query.fields().include("contract_date").include("trade_price");

        return operations.find(query, AptTrade.class)
                .collect(Collectors.groupingBy(i->i.getContractDate(),
                        Collectors.collectingAndThen(Collectors.averagingLong(i->i.getTradePrice()), i-> i.longValue())));
    }

    public Mono<Map<String,Long>> plotGraphSaleCountByDate() {
        Criteria criteria = new Criteria();
        Query query = new Query(criteria);
        query.fields().include("contract_date");

        return operations.find(query, AptTrade.class)
                .flatMap(i -> Mono.just(AptTrade.builder()
                        .contractDate(i.getContractDate().substring(0, 6))
                        .build()))
                .collect(Collectors.groupingBy(i->i.getContractDate(), Collectors.counting()));

    }

    public Mono<Map<String,Long>> plotGraphSalesCountByRegionForMonth(String date) {
        Criteria criteria = Criteria.where("contract_date").regex("^" + date);
        Query query = new Query(criteria);
        query.fields().include("contract_date").include("ward");

        return operations.find(query, AptTrade.class)
                .flatMap(i -> Mono.just(AptTrade.builder()
                        .contractDate(i.getContractDate().substring(0, 6))
                        .ward(i.getWard())
                        .build()))
                .collect(Collectors.groupingBy(i-> i.getContractDate(), Collectors.counting()));
    }

    public Mono<Map<Long, Long>> plotGraphCostByArea() {
        Criteria criteria = new Criteria();

        Query query = new Query();
        query.fields().include("net_leasable_area").include("price_per_area");

        return operations.find(query, AptTrade.class)
                .doOnNext(i-> System.out.println(i))
                .collectMap(i-> (long) (i.getNetLeasableArea().floatValue()/3.3), i-> (long) i.getPricePerArea().floatValue());
    }

    //5번 메서드..마지막에..
//    public Mono<Map<Long, Long>> plotGraphCostRaisebyRegionFor3Month() {
//        LocalDate today = LocalDate.now();
//        String threeMonthAgo = today.minusMonths(3).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
//
//        Aggregation aggregation = Aggregation.newAggregation(
//                Aggregation.match(Criteria.where("contract_date").gte(threeMonthAgo)),
//                Aggregation.group("ward")
//                        .avg("trade_price").as("avgPrice")        );
//
//
//
//        return operations.aggregate(aggregation, "aptTrade", Map.class)
//                .doOnNext(result -> System.out.println("결과 출력: " + result))
//                .collectMap(result -> (long) result.get("trade_price"), result -> (long) result.get("trade_price"))
//                ;

//        Criteria criteria = new Criteria().orOperator(
//                Criteria.where("contract_date").regex("^" + currentDate),
//                Criteria.where("contract_date").regex("^" + oneMonthAgo),
//                Criteria.where("contract_date").regex("^" + twoMonthAgo)
//        );
//
//        Query query = new Query();
//        query.fields().include("contract_date").include("trade_price").include("ward");
//
//        operations.find(query, AptTrade.class)
//                .collect(Collectors.groupingBy(i -> i.getWard()))
//                .doOnNext(i -> {
//                    System.out.println("test: " + i);
//                    System.out.println(i.getClass());})
//
////                .doOnNext(i -> System.out.println("test: " + "contractDate="+i.get("contractDate")+", trade_price="+i.get("trade_price")+", ward="+i.get("ward")))
//                        .subscribe();
//

//    }

//        return operations.find(query, AptTrade.class)
//                .collectList()
//                .flatMap(trades -> {
//                    // 행정구별로 그룹화하여 가격 데이터 준비
//                    Map<Long, List<Long>> wardPriceMap = new HashMap<>();
//                    for (AptTradeDto trade : trades) {
//                        long wardId = trade.getWard().getId(); // 가정
//                        wardPriceMap.computeIfAbsent(wardId, k -> new ArrayList<>()).add(trade.getTradePrice());
//                    }
//
//                    // 행정구별 가격 상승률 계산
//                    Map<Long, Long> wardPriceIncreaseMap = new HashMap<>();
//                    for (Map.Entry<Long, List<Long>> entry : wardPriceMap.entrySet()) {
//                        long wardId = entry.getKey();
//                        List<Long> prices = entry.getValue();
//                        if (prices.size() >= 3) {
//                            long currentPrice = prices.get(0);
//                            long oneMonthAgoPrice = prices.get(1);
//                            long twoMonthsAgoPrice = prices.get(2);
//
//                            long priceIncreaseRate = calculatePriceIncreaseRate(currentPrice, oneMonthAgoPrice, twoMonthsAgoPrice);
//                            wardPriceIncreaseMap.put(wardId, priceIncreaseRate);
//                        }
//                    }
//
//                    return Mono.just(wardPriceIncreaseMap);
//                });



//        return operations.find(query, AptTrade.class)
//                .flatMap(i -> Flux.just(AptTrade.builder()
//                        .contractDate(i.getContractDate().substring(0, 6))
//                        .tradePrice(i.getTradePrice())
//                        .ward(i.getWard())
//                        .build()))
//                .collect(Collectors.groupingBy());

//    }

//    public Mono<Map<Long, Long>> costRaiseTop5Bottom5ForYear() {
//        LocalDate today = LocalDate.now();
//        String BeingOftoday = today.format(DateTimeFormatter.ofPattern("yyyyMM"));
//
//        LocalDate AYearAgo = today.minusYears(1);
//        String BeginOfAYearAgo = AYearAgo.format(DateTimeFormatter.ofPattern("yyyyMM"));
//
//        Criteria criteria = Criteria.where("contract_date").gte(BeginOfAYearAgo);
//
//        Query query = new Query(criteria);
//        query.fields().include("apt_name").include("trade_price");
//
//        operations.find(query, AptTrade.class).collect(Collectors.groupingBy(i->i.))
//
//        Flux<AptTrade> fluxAptTrade = operations.find(query, AptTrade.class);
//
//        Mono<Map<String, Double>> thisYear = fluxAptTrade.filter(i-> i.getContractDate() != null && i.getContractDate().substring(0, 6).equals(BeingOftoday))
//                .collect(Collectors.groupingBy(i->i.getAptName(), Collectors.averagingLong(i->i.getTradePrice())));
//
//        Mono<Map<String, Double>> aYearsAgo = fluxAptTrade.filter(i-> i.getContractDate() != null && i.getContractDate().substring(0, 6).equals(BeginOfAYearAgo))
//                .collect(Collectors.groupingBy(i -> i.getAptName(), Collectors.averagingLong(i -> i.getTradePrice())));
//
//        thisYear.
//
//
//        return Mono.just(map);
//
//    }

    public Mono<Map<String,Long>> tardeCountRaiseTop5ForMonth() {
        LocalDate now = LocalDate.now();
        String aYearAgo = now.minusYears(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        Criteria criteria = Criteria.where("contract_date").gte(aYearAgo);

        Query query = new Query(criteria);
        query.fields().include("apt_name");

        List<Map<String, Long>> list = new ArrayList<>();
        return operations.find(query, AptTrade.class)
                .collect(Collectors.groupingBy(i -> i.getAptName(), Collectors.counting()))
//                .flatMap(i -> {
////                    Set<Map.Entry<String, Long>> j = i.entrySet();
//                    list.add(i);
//                    return Mono.just(list);
//                })
                .flatMap(map -> {
                    Map<String, Long> sortedMap = map.entrySet().stream()
                            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                            .limit(5)
                            .collect(Collectors.toMap(
                                    Map.Entry::getKey,
                                    Map.Entry::getValue,
                                    (e1, e2) -> e1,
                                    LinkedHashMap::new
                            ));
                    return Mono.just(sortedMap);
                });
    }
}