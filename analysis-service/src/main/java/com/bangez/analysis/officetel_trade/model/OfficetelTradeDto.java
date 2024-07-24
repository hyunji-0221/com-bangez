package com.bangez.analysis.officetel_trade.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfficetelTradeDto {

    private String officetelTradeId ;
    private String address;
    private String builtYear;
    private String contractDate;
    private String floor;
    private String legalCode;
    private Float netLeasableArea;
    private String officetelName;
    private Float pricePerArea;
    private Long tradePrice;
    private String ward;
}
