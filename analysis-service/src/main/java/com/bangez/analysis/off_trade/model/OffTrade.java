package com.bangez.analysis.off_trade.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("offTrades")
public class OffTrade {
    @Id
    private String offTradeId ;

}
