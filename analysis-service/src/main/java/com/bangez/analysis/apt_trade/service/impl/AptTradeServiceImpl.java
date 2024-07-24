package com.bangez.analysis.apt_trade.service.impl;

import com.bangez.analysis.apt_trade.model.AptTrade;
import com.bangez.analysis.apt_trade.repository.AptTradeRepository;
import com.bangez.analysis.apt_trade.service.AptTradeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AptTradeServiceImpl implements AptTradeService {

    private final AptTradeRepository repository;

}