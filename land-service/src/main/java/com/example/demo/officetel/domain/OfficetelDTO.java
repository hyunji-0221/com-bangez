package com.example.demo.officetel.domain;

import java.util.List;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfficetelDTO {

    private String id;
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
    private String atclCfmYmd; //date?
    private String lat;
    private String lng;
    private String atclFetrDesc;
    private List<String> tagList;
    private String bildNm;
    private String town;
    private String roadAddress;
    private String address;
}