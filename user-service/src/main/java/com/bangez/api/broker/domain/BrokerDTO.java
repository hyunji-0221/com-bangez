package com.bangez.api.broker.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
@Component
public class BrokerDTO {
    private Long id;
    private String brokerName;
    private Long phone;
    private Long brokerageNum;
    private Long businessNum;
    private String companyName;
}
