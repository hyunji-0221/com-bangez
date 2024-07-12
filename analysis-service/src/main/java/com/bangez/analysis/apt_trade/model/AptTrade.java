package com.bangez.analysis.apt_trade.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("aptTrades")
public class AptTrade {
    @Id
    private String aptTradeId ;

}
