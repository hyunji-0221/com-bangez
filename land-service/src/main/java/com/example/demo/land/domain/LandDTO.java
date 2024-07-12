package com.example.demo.land.domain;


import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LandDTO {

    private long id;
    private long atclNo ;
    private String atclNm;
    private String rletTpNm;
    private String tradTpNm;
    private String flrInfo;
    private long prc;
    private long rentPrc;
    private String hanPrc;
    private String spc1;
    private String spc2;
    private String direction;
    private String atclFetrDesc;
    private String tagList;
    private String bildNm;
    private String atclCfmYmd;
}